<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<title>Search Results</title>
		<meta name="layout" content="main">
		
	</head>
	
	<body id="index">
		<h1 id="search_results">Search Results</h1>
		
		<div id="searchResults">
			<ul>
				<g:each in="${searchResult.results}" var="person">
					<li>${person.userRealName} 
						<g:link 
						controller="status"
						action="follow"
						id="${person.id}">Follow</g:link></li>
				</g:each>
			</ul>
			
		</div>
	</body>
</html>