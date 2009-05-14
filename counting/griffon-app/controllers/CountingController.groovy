
class CountingController {
    // these will be injected by Griffon
    def model
    def view
    def builder

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
    }

    /*
    def action = { evt = null ->
    }
    */
	def click = { evt = null ->
		println "BUTTON WAS CLICKED"
		model.count++
		println "Count = ${model.count}"
	}
	
	def slowClick = { evt = null ->
		println "SLOW BUTTON WAS CLICKED"
		Thread.sleep(5000)
		model.countSlow++
		println "Slow Count = ${model.countSlow}"
	}
	
	def concurrentClick = { evt = null ->
		println "CONCURRENT BUTTON WAS CLICKED"
		doOutside{			
			Thread.sleep(5000)
			edt {				
				model.countConcurrent++
				println "Concurrent Count = ${model.countConcurrent}"
			}
		}
	}
	
	def exit = { evt = null ->
		app.shutdown()
	}
	
	def about = { evt = null ->
		//JOptionPane.showMessageDialog(null, '''This is the Counting Application''')
		builder.optionPane().showMessageDialog(null,
			"This is the Counting Application'")
	}
}