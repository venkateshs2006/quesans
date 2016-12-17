<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<%@ page session="false" %>
<link rel="stylesheet" href="resources/jquery-ui.css">
<script type="text/javascript" src="resources/jquery.min.js"></script>
<script src="resources/jquery-ui.js"></script>
<script type="text/javascript">
    $(function() {   
             
        $( "#tabs" ).tabs();
    });
</script>
<div id="tabs">
<ul>
<c:if test="${!empty results}">
<c:set var="counter" value="0" scope="page" />
<c:forEach items="${results}" var="result">
<c:set var="counter" value="${counter + 1}" scope="page"/>
    <li><a href="#tabs-${counter}">${result.key}</a></li> 
   
 </c:forEach>
  		</c:if>
  		  </ul>


<c:if test="${!empty results}">
<c:set var="counter" value="0" scope="page" />
<c:forEach items="${results}" var="result">
<c:set var="counter" value="${counter + 1}" scope="page"/>
<div id="tabs-${counter}">
<c:choose>
    <c:when test="${fn:startsWith(result.value, 'http:')}">
        <a href=" ${result.value}" target="_blank"> ${result.value}</a>
    </c:when>    
    <c:otherwise>
      ${result.value}
    </c:otherwise>
</c:choose>



</div>
 </c:forEach>
</c:if>
</div>