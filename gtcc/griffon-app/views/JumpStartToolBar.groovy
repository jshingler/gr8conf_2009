
println "INITIALIZING: JumpStartToolBar"

toolBar(id:'toolbar', rollover:true, visible:controller.showToolbar) {
	  //button(XXXAction, text:null)
	button(loginAction, text:null)
	button(refreshAction, text:null)

}
