<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- DC Table Styles I CSS -->
<link type="text/css" rel="stylesheet"
	href="http://cdn.dcodes.net/2/tables1/css/dc_tables1.css" />
</head>
<body>
	<style type="text/css">
body {
	background-image: url('http://cdn.dcodes.net/2/bg_images/wood/w15.jpg');
}
</style>
	<center>
		<h2>send Message</h2>


		<c:url value="/sendMessage" var="url"></c:url>

		<form:form action="${url}" method="post" commandName="message">
			<table>
				<tr>
					<td><form:label path="messageId">message Id</form:label></td>
					<td><form:input path="messageId" disabled="true"
							class="form-control" /> <form:hidden path="messageId" /></td>
				</tr>
				<tr>
					<td><form:label path="senderName">SenderName</form:label></td>
					<td><form:input path="senderName" class="form-control"></form:input></td>

				</tr>
				<tr>
					<td><form:label path="message">Message</form:label></td>
					<td><form:input path="message" class="form-control"></form:input></td>

				</tr>


				<tr>
					<td colspan="2"><input type="submit" value="Send Message"></td>
				</tr>
			</table>
		</form:form>

		<br />
		<br />
		<br />


		<!-- DC Table Styles I:3 Start -->
		<table class="dc_table_s3" summary="Sample Table" style="width: 80%;">

			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">senderName</th>
					<th scope="col">Message</th>
					<th scope="col">Time</th>
				</tr>
			</thead>
			</tr>
			</thead>
			<c:forEach var="message" items="${messageList}">
				<tr>
					<td align="center">${message.messageId}</td>
					<td align="center">${message.senderName}</td>
					<td align="center">${message.message}</td>
					<td align="center">${message.tstamp}</td>



				</tr>
			</c:forEach>

		</table>
		<!-- DC Table Styles I:3 End -->
</body>
</html>
