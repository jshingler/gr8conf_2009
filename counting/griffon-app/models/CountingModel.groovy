import groovy.beans.Bindable

@Bindable
class CountingModel {
   // @Bindable String propName
	def count = 0
	def countSlow = 0
	def countConcurrent = 0
}