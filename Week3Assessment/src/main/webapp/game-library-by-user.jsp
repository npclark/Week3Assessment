<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Libraries</title>
</head>
<body>
	<form method = "post" action = "listnavigationServlet">
		<table>
			<c:forEach items="${requestScope.allLists}" var="currentList">
				<tr>
					<td><input type="radio" name="id" value="${currentList.id}"></td>
					<td><h2>${currentList.listName}</h2></td>
				</tr>
				<tr><td colspan="3">Trip Date: ${currentList.tripdate}</td></tr>
				<tr><td colspan="3">Player: ${currentList.player.playerName}</td></tr>
				<c:forEach var = "listVal" items="${currentList.listOfGames}">
					<tr><td></td><td colspan="3">${listVal.title}, ${listVal.genre}</td></tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToList">
		<input type="submit" value="delete" name="doThisToList">
		<input type="submit" value="add" name="doThisToList">
	</form>
	
	<a href="addGamesForListServlet">Create a new List</a> <br />
	<a href="index.html">Insert a new game</a>
</body>
</html>