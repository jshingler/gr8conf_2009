
import org.jdesktop.swingx.JXTipOfTheDay
import org.jdesktop.swingx.tips.TipOfTheDayModel
import org.jdesktop.swingx.tips.TipLoader

    



import java.awt.Component
import java.awt.Cursor
import javax.swing.*
import java.util.prefs.Preferences

import org.jdesktop.swingx.JXTipOfTheDay
import org.jdesktop.swingx.tips.TipOfTheDayModel
import org.jdesktop.swingx.tips.TipLoader
import org.jdesktop.swingx.JXErrorPane
import org.jdesktop.swingx.error.ErrorInfo

class JumpStartMixin {
	
	Cursor hourglassCursor = new Cursor(Cursor.WAIT_CURSOR)
    Cursor normalCursor = new Cursor(Cursor.DEFAULT_CURSOR)
	
	def busy = {view.setCursor(hourglassCursor)}
	def norm = {view.setCursor(normalCursor)}
	
	// Preferences
    private prefs = Preferences.userNodeForPackage(JumpStartMixin)
    boolean fullStackTraces = prefs.getBoolean('fullStackTraces',
            Boolean.valueOf(System.getProperty("groovy.full.stacktrace", "false")))
	
	void exit(event) {
        app.shutdown()
    }

    void fullStackTraces(EventObject evt) {
        fullStackTraces = evt.source.selected
        System.setProperty("groovy.full.stacktrace",
                Boolean.toString(fullStackTraces))
        prefs.putBoolean('fullStackTraces', fullStackTraces)
    }
    
    private void showDialog( dialogName ) {
        def dialog = view."$dialogName"
        if( dialog.visible ) return
        dialog.pack()
        int x = app.appFrames[0].x + (app.appFrames[0].width - dialog.width) / 2
        int y = app.appFrames[0].y + (app.appFrames[0].height - dialog.height) / 2
        dialog.setLocation(x, y)
        dialog.show()
     }

     private void hideDialog( dialogName ) {
        def dialog = view."$dialogName"
        dialog.hide()
     }
     
     private void handleException(Exception e) {
          def errorInfo = new ErrorInfo(e.getClass().getName(),
              e.getMessage(),
              null,
              null,
              e,
              null,
              null)
          JXErrorPane.showDialog(null, errorInfo)
     }
     
     private void execWithExceptionHandling(Closure clozure) {
          try {
             clozure.call()
          } catch (Exception e) {
              handleException(e)
          }
     }


  
  //--------------------------------------------------------------------------
  // StatusBar
  JLabel statusLabel
  def status = {message -> statusLabel.text = "$message"}


//--------------------------------------------------------------------------
    // ToolBar
    Component toolbar
    
    boolean showToolbar = prefs.getBoolean('showToolbar', true)
    
    void showToolbar(EventObject evt) {
        showToolbar = evt.source.selected
        prefs.putBoolean('showToolbar', showToolbar)
        toolbar.visible = showToolbar
    }


    //--------------------------------------------------------------------------
    // About
    void showAbout(event) {
        //showDialog("aboutDialog")
        def dialog = view."aboutDialog"
        if( dialog.visible ) return
        dialog.pack()
        int x = app.appFrames[0].x + (app.appFrames[0].width - dialog.width) / 2
        int y = app.appFrames[0].y + (app.appFrames[0].height - dialog.height) / 2
        dialog.setLocation(x, y)
        dialog.show()
    }
    
    JXTipOfTheDay totd
    
    void doTips() {
        if (!totd) {
            Properties tips = new Properties()
            tips.load(this.getClass().getResourceAsStream( "tips.properties" ));
            totd = new JXTipOfTheDay(TipLoader.load(tips));
        }
        totd.showDialog(null);
    }

    void showTips(event) {
        doTips()
    }
}
      