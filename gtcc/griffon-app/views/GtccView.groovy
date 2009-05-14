import net.miginfocom.swing.MigLayout

application(title:'gtcc',  /*size:[320,480], location:[50,50],*/ pack:true, locationByPlatform:true) {
    buildJumpStartView()

	panel(layout: new MigLayout("flowy, insets 0 0 0 0", "[grow, fill]")) {

	  def mig = new MigLayout("flowy, insets 0 10 0 0")
	  panel (id: "userPanel", layout: mig) {
	    label(id: "userImageLabel", constraints: "spany, wrap")
		updateUserImage()
		
	    label(text: bind{model.user?.userRealName})
	    label(text: bind{model.user?.username})
	    label(text: bind{model.user?.description})
	  }
	  separator(constraints: "growx")
	    scrollPane(constraints: "height 200:400, growx, growy") {
	      panel(id: "statusesPanel", layout: new MigLayout("flowy, insets 0 0 0 0, fill", "[grow, fill]"))
	    }
	    separator(constraints: "growx")
	  
	  panel(layout: new MigLayout("insets 0 0 0 0, fill")) {
	    textArea id: 'statusText',  constraints: "width 400, growx"
	    button updateStatusAction
	  }
	}
}

def updateUserImage() {
	println "image name: ${model.user.imageName()} class: ${this.getClass()}"
	userImageLabel.icon = imageIcon(resource: model.user.imageName(), class:this.getClass())
}
