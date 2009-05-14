import net.sf.ehcache.Element
import grails.converters.*

class StatusController {

	def twitterCache
	
	def index = {
		def messages = findMessages()
		
		def feedOutput = {
			title = "Twitter Status Messages"
			link = g.link(controller:"status", absolute:true)
			description = "Long decription"
			
			for(msg in messages) {
				entry("${msg.person.userRealName} said:") {
					link = g.link(controller:"status", absolute:true)
					msg.message
				}
			}
		}
		withFormat {
			html([messages: messages])
			xml {
				render messages as XML
			}
			json {
				render messages as JSON
			}
			
			rss {
				render(feedType:"rss", feedOutput)
			}
			atom {
				render(feedType:"atom", feedOutput)
			}
		}

	}


	
	private findMessages() {
		def messages = twitterCache?.get(principalInfo.username)?.value
		if(!messages) {
			def p = lookupPerson()
			messages = Status.withCriteria {
				or {
					person {
						eq 'username', p.username
					}
					if(p.following) {
						inList 'person', p.following
					}
				}
				maxResults 20
				order "dateCreated", "desc"
			}

			twitterCache.put new Element(principalInfo.username, messages)
		}
		return messages
	}
	
	def update = {
		def status = new Status(params)
		
		status.person = lookupPerson()
		status.save()
		twitterCache.flush()
		render template:"message", collection:findMessages(), var:"status"
	}
	
	def follow = {
		def loggedIn = lookupPerson()
		def p = Person.get(params.id)
		loggedIn.addToFollowing(p)
		loggedIn.save()
		redirect action:"index"
	}
	
	private lookupPerson() {
		Person.findByUsername(principalInfo.username)
	}

}