<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<title>What are you doing now?</title>
		<meta name="layout" content="main">
		<g:javascript library="prototype"></g:javascript>
	</head>
	<body id="index">
		<div id="searchBox">
			<g:form name="search" 
			  url="[controller:'searchable']">
			    <strong>Find People:</strong>
				<g:textField name="q"></g:textField>
			</g:form>
		</div>
		<h1 id="what_are_you_doing_now?">What are you doing now?</h1>
		
		<g:formRemote name="myForm" url="[action:'update']" update="messages">
			<g:textArea name="message"></g:textArea> <br>
			
			<g:submitButton name="Update"></g:submitButton>
		</g:formRemote>
		
		<div id="messages">
			<g:render template="message" 
					  collection="${messages}" 		
					  var="status"></g:render>
		</div>
	</body>
	
</html>