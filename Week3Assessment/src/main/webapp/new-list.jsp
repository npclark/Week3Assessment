<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new List</title>
</head>
<body>
	<form action = "createNewListServlet" method="post">
		List Name: <input type="text" name="listName"><br />
		Trip date: <input type="text" name="month" placeholder="mm" size=4> <input type="text" name="day" placeholder="dd" size=4>, <input type="text" name="year" placeholder="yyyy" size=4>
		Player Name: <input type="text" name="playerName"><br />
		
		Available Games:<br />
		<select name="allGamesToAdd" multiple size="6">
			<c:forEach items="${requestScope.allGames}" var="currentgame">
				<option value="${currentgame.id}">${currentgame.title} | ${currentgame.genre}</option>
			</c:forEach>
		</select>
		<br />
		<input type="submit" value="Create List and Add Items">
	</form>
	<a href="index.html">Add new games</a>
</body>
</html>