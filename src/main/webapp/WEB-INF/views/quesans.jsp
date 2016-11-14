<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>SearchEngine Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h3>Question Answer List</h3>
<c:if test="${!empty listQuesAns}">
	<table class="tg">
	<tr>
		<th width="80">Question ID</th>
		<th width="120">Question</th>
		<th width="120">Answer</th>	
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listQuesAns}" var="quesAns">
		<tr>
			<td>${quesAns.id}</td>
			<td>${quesAns.question}</td>
			<td>${quesAns.answer}</td>			
			<td><a href="<c:url value='/edit/${quesAns.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${quesAns.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>