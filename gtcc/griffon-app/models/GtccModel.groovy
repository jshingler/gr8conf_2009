import groovy.beans.Bindable

class GtccModel {
   // @Bindable String propName
   @Bindable Person user = new Person()
   @Bindable boolean loggedIn = false
}