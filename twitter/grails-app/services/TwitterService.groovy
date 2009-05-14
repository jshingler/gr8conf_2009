class TwitterService {

    boolean transactional = true

	static expose = ['jms']
	
	def twitterCache
    def onMessage(status) {
		def p = status.person
		
		def usernames = Person.withCriteria {
			projections { property "username" }
			following {
				eq 'username', p.username
			}
		}
		
		for(username in usernames) {
			twitterCache.remove username
		}
    }
}
