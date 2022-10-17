<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List</title>
</head>
<body>
	<form action = "editListDetailsServlet" method="post">
		<input type="hidden" name = "id" value="${listToEdit.id}">
		List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br />
		
		Trip date: <input type="text" name="month" placeholder="mm" size="4" value="${month}"> <input type="text" name="day" placeholder="dd" size="4" value="${date}">, <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
		
		Player Name: <input type="text" name="playerName" value="${listToEdit.player.playerName}"><br />
		
		Available Items:<br />
		<select name="allGamesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allGames}" var="currentgame">
				<option value="${currentgame.id}">${currentgame.title} | ${currentgame.genre}</option>
			</c:forEach>
		</select>
	</form>
	
	<a href="index.html">Add new games instead</a>
</body>
</html>