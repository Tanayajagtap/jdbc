<%@page import="com.airline.entity.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
</head>
	<body align="center">
		<h2>Available Flights</h2>
			<%
				List<Flight> flights = (List<Flight>)request.getAttribute("flights");
				for(Flight f: flights){
			%>
			<p> 
				
				Flight Number: <%=f.getFlightNumber()%> | <%=f.getSource()%>  to <%=f.getDestination()%><br>
				Schedule Date: <%=f.getFlight_date()%>  | Price : <%=f.getPrice()%> <br>
				<br>
				
				<form action="bookFlight" method ="post">
					<input type="hidden" name="flightId" value=<%=f.getId()%>>
					<input type ="submit" value="Book">
				</form>
				<hr>
			
			</p>
			<%
				}
			%>
			
	</body>
</html>