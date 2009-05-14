class StatusPanelController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
		model.id = args.id
		model.message = args.status.message
		model.dateCreated = args.status.dateCreated
		model.personId = args.status.personId
		model.person = args.status.person
		
    }

    /*
    def action = { evt = null ->
    }
    */
}