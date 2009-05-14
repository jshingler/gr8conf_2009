class Status implements Serializable {

	String message
	Date dateCreated
	static belongsTo = [person:Person]
	
    static constraints = {
		message blank:false, size:1..140
    }

	transient jmsTemplate
	def afterInsert = {
		try {
			jmsTemplate.convertAndSend("twitter", this)
		}catch(e) {
			log.error "Error sending JMS message: ${e.message}",e
		}
	}
}
