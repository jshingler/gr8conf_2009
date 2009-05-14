
		action(id: 'exitAction',
			name: 'Exit',
			closure: controller.&exit,
			mnemonic: 'x',
			accelerator: 'F4',
			shortDescription: 'Exit Client'
		)		

		action(id: 'fullStackTracesAction',
			name: 'Show Full Stack Traces',
			closure: controller.&fullStackTraces,
			mnemonic: 'F'
		)

		action(id: 'saveAction',
			name: 'Save',
			closure: controller.&save,
			mnemonic: 'S',
			//accelerator: shortcut('S'),
			smallIcon: imageIcon(resource:"/com/famfamfam/silk/disk.png", class:controller.getClass()),
			shortDescription: 'Save',
			enabled: true 
		)
        action(id:'showToolbarAction',
            name: 'Show Toolbar',
            closure: controller.&showToolbar,
            mnemonic: 'T'
        )
        
        action(id: 'aboutAction',
            name: 'About',
            closure: controller.&showAbout,
            mnemonic: 'A',
            accelerator: 'F1',
            shortDescription: 'Find out about this application'
        )
        
        action(id: 'tipsAction',
            name: 'Tips',
            closure: controller.&showTips,
            mnemonic: 'T',
            shortDescription: 'Tips'
        )

		action(id: 'loginAction',
				name: 'Login',
				closure: controller.&showLogin,
				mnemonic: 'l',
				shortDescription: 'Login',
				smallIcon: imageIcon(resource:"icons/login.png", class:controller.getClass()),
				)
		
		action(id: 'updateStatusAction',
					name: 'Update',
					closure: controller.&updateStatus,
					mnemonic: 'U',
					enabled: bind {model.loggedIn},
					shortDescription: 'Update Status'
					)
		action(id: 'refreshAction',
					name: 'Refresh',
					closure: controller.&updateStatuses,
					mnemonic: 'R',
					shortDescription: 'Refesh',
					enabled: bind {model.loggedIn},
					smallIcon: imageIcon(resource:"icons/refresh.png", class:controller.getClass())
					)
		
		
		
        