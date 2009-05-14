application(title:'counting',  /*size:[320,480], location:[50,50],*/ pack:true, locationByPlatform:true) {
    
	build Actions
	build MenuBar
	
	gridLayout()
    button text: bind {model.count}, action: clickAction
	label text: bind {model.count}
	
	button id: 'slowClickButton', text: "Slow Click", action: slowClickAction
	label text: bind {model.countSlow}
	
	button id: 'concurrentClickButton', text: "Concurrent Click", action: concurrentClickAction
	label text: bind {model.countConcurrent}
	
	
	
	
}