<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>
	<form action="editGameServlet" method="post">
		Title: <input type="text" name="title" value="${gameToEdit.title}">
		Genre: <input type="text" name="genre" value="${gameToEdit.genre}">
		<input type="hidden" name="id" value="${gameToEdit.id}">
		<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>