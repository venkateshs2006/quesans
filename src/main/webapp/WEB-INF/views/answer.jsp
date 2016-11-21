<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>SearchResult Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>

<h3>SearchEngine List</h3>
<c:if test="${!empty results}">
	<table class="tg">
	<tr>
		<th width="120">SearchEngine Name</th>
		<th width="120">Search Engine Result</th>		
	</tr>
	<c:forEach items="${results}" var="result">
		<tr>
			<td><c:out value="${result.key}"/></td>			
			<td><c:out value="${result.value}"/></td>			
		</tr>
	</c:forEach>	
	</table>
</c:if>
</body>
</html>