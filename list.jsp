<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="m" items="${list}">
  ${m.id}:${m.name}:${m.gender}<br>
</c:forEach>

<%@include file="../footer.html" %>
