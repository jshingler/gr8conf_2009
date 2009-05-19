import org.jdesktop.swingx.JXLoginPane
import javax.swing.Action
import javax.swing.Timer

class GtccController {
    // these will be injected by Griffon
    def model
    def view
    def twitterService = new TwitterService()

	Timer refreshTimer
	Action refreshTimerAction

	void mvcGroupInit(Map args) {
	    // this method is called after model and view are injected

	    refreshTimerAction = action( id: "refreshTimerAction",
	            name: 'RefreshTimer',
	            closure: this.&refreshTimerTask
	        )
	 
	    refreshTimer = new Timer(30000, refreshTimerAction)
	}

	void refreshTimerTask(evt) {
	   	if (!model.loggedIn) {
			println "REFRESH TIMER ACTION - NOT LOGGED IN"
		} else {		
	   		println "REFRESH TIMER ACTION - Date()}"
	        updateStatuses()
		}
	}
	

    /*
    def action = { evt = null ->
    }
    */
	def showLogin = { evt = null ->
		println "SHOW LOGIN"

		def loginPane = new JXLoginPane()
		loginPane.loginService = twitterService
		loginPane.bannerText = "GTCC Login"
		loginPane.message = "You MUST Login before you can access your Tweets"
		loginPane.showLoginDialog(null, loginPane)
		
		status("Logging in")
		model.user = twitterService.getUser(twitterService?.userContext?.userName)
		view.updateUserImage()
		updateStatuses()
		model.loggedIn= true
		refreshTimer.start()
		status("Ready . . .")
	}
	
	def updateStatuses = { evt = null ->
	   println "UPDATE STATUSES - ${new Date()}"
	   status("Updating statuses")
	   def statuses = twitterService.getStatuses()
	   view.statusesPanel.removeAll()
	   statuses.each {
		println "Dumping Status: ${it.dump()}"
	   	def mvcId = "id}"
	   	createMVCGroup("StatusPanel",mvcId, [mvcId:mvcId, status: it, statusesPanel: view.statusesPanel])
	   }	
	   view.statusesPanel.revalidate()
	   
	   status("Updated Statuses . . . ")
	}
	
	def updateStatus = { evt = null ->
	    twitterService.status("${view.statusText.text}")
	    updateStatuses()
	    view.statusText.text = ""
	}
	
	
	
	
	
}