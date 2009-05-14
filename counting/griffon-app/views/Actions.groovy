// create the actions
action(id: 'clickAction',
		name: 'Click Me',
		closure: controller.&click,
		shortDescription: 'Increment the Click Count'
		)
		
action(id: 'exitAction',
		name: 'Exit',
		closure: controller.&exit,
		mnemonic: 'X',
	    accelerator: 'F4',
		shortDescription: 'Exit the Application'
		)
		
action(id: 'aboutAction',
		name: 'About',
		closure: controller.&about,
		mnemonic: 'A',
	    accelerator: 'F1',
		shortDescription: 'Learn about the Application'
		)
		
action(id: 'slowClickAction',
		name: 'slowClick',
		closure: controller.&slowClick,
		shortDescription: 'A Slow Click'
		)

action(id: 'concurrentClickAction',
		name: 'concurrentClick',
		closure: controller.&concurrentClick,
		shortDescription: 'A Concurrent Click'
		)




