application {
    title='Gtcc'
    startupGroups = ['gtcc']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "StatusPanel"
    'StatusPanel' {
        model = 'StatusPanelModel'
        view = 'StatusPanelView'
        controller = 'StatusPanelController'
    }

    // MVC Group for "gtcc"
    'gtcc' {
        model = 'GtccModel'
        view = 'GtccView'
        controller = 'GtccController'
    }

}
