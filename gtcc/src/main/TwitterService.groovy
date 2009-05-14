import org.jdesktop.swingx.auth.LoginService
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.PUT
import static groovyx.net.http.ContentType.TEXT

class TwitterService extends LoginService {
	def http = new HTTPBuilder("http://localhost:8080/")
	def userContext
	
	boolean authenticate(String name, char[] password, String server) {
		println "Logging in as ${name} / ${password}"
		userContext = new UserContext(userName: name, password: new String(password))
		println "XXX"
		return login(userContext)
	}
	
	def login = { userContext ->
		println "Logging in as ${userContext.userName} / ${userContext.password}"
		http.auth.basic( userContext.userName, userContext.password )
	
		http.request(GET,TEXT) { req ->
		  uri.path = "/twitter/person/findByUsername.xml"
		  uri.query = [ username: userContext.userName ]

		  response.success = { resp, reader ->
			return true
		  }
		  return false
	    }	
	}
	
	def peopleCache = [:]

	def getUser = { userName ->

			def person 
			XmlSlurper slurper = new XmlSlurper()

			http.request(GET,TEXT) { req ->
			  uri.path = "/twitter/person/findByUsername.xml"
			  uri.query = [ username: userName ]

			  response.success = { resp, reader ->
				def p = slurper.parseText(reader.text)

				person = new Person(id: p.@id)
				person.with {
					username = p.username
					userRealName = p.userRealName
					description = p.description
					email = p.email
					emailShow = p.emailShow
					enabled = p.enabled
					p.following.children().each{
						following << it.@id
					}
				}		

				def key = person.id
				peopleCache.key = person	
				return person
			  }
			}
		}
		
		def getStatuses = {

			def statuses = []
			XmlSlurper slurper = new XmlSlurper()
			
			http.request(GET,TEXT) { req ->
			  uri.path = "/twitter/status/index.xml"

			  response.success = { resp, reader ->
				def l = slurper.parseText(reader.text)
					
				l.children().each { s ->
					def status = new Status(id: s.@id)
					status.with {
						id = s.@id
						message = s.message
						dateCreated = s.dateCreated
						personId = (s.person.@id)
						person = getPersonById(s.person.@id)
					}
					statuses << status
				}			
				return statuses
			  }
			}
		}
		
	def getPersonById = { id ->
		
		if (peopleCache.id) return peopleCache.id
		
		def person 
		XmlSlurper slurper = new XmlSlurper()
		
		http.request(GET,TEXT) { req ->
		  uri.path = "/twitter/person/show.xml"
		  uri.query = [ id: id ]

		  response.success = { resp, reader ->
			def p = slurper.parseText(reader.text)
			
			person = new Person(id: p.@id)
			person.with {
				username = p.username
				userRealName = p.userRealName
				description = p.description
				email = p.email
				emailShow = p.emailShow
				enabled = p.enabled
			}		
			
			peopleCache.userName = person	
			return person
		  }
		}
	}
	
	def status = { message ->
		http.request(PUT,TEXT) { req ->
		  uri.path = "/twitter/status/update"
		  uri.query = [ message: message ]

		  response.success = { resp, reader -> }
		}
	}
	
	
	
	
	
		
}

