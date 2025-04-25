<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Flight</title>
</head>
	<body align ="center">
		<h2> Search Flight </h2>
			<form action ="searchFlight" method ="post">
				From : <input type = "text" name ="from"><br>
				<br>
				To : <input type = "text" name ="to"><br>
				<br>
				Date : <input type = "date" name ="date"><br>
				<br>
			<input type ="submit" value="Search">
			</form>
	
	</body>
</html>