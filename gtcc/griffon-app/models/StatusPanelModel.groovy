import groovy.beans.Bindable

class StatusPanelModel {
   // @Bindable String propName
	@Bindable String id
	@Bindable String message
	@Bindable String dateCreated
	@Bindable String personId
	@Bindable Person person
	
}