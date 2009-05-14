class Person {	
	def id
	def username
	def description
	def email
	def emailShow
	def enabled
	def userRealName
	def following = []	
	
	def imageName = {
		username ? "${username}.jpg" : "griffon.jpg"
	}
	
}
