
println "INITIALIZING: JumpStartMenuBar"

jxmenuBar {
    menu(text: 'File', mnemonic: 'F') {
	    menuItem(loginAction)
        separator()
        menuItem(exitAction)
    }

    menu(text: 'Edit', mnemonic: 'E') {
    }

    menu(text: 'View', mnemonic: 'V') {
        checkBoxMenuItem(fullStackTracesAction, selected: controller.fullStackTraces)
        checkBoxMenuItem(showToolbarAction, selected: controller.showToolbar)
    }

    glue()
    menu(text: 'Help', mnemonic: 'H') {
        menuItem(tipsAction)
        menuItem(aboutAction)
    }
}
