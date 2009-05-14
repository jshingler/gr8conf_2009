// Place your Spring DSL code here
beans = {
	authenticationEntryPoint(org.springframework.security.ui.basicauth.BasicProcessingFilterEntryPoint) {
		realmName = 'Grails Realm'
		}
	
	
   twitterCache(org.springframework.cache.ehcache.EhCacheFactoryBean)  {
	  timeToLive = 1200	
   }
}