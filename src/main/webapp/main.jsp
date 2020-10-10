<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages"/>

<!DOCTYPE>
<html>
<head>
    <%@ include file="/WEB-INF/fragment/head.jspf" %>
    <title>Title</title>
</head>
<%@ include file="/WEB-INF/fragment/navbar.jspf" %>
<body>
<h1><fmt:message key="title.greeting"/> ${sessionScope.user.firstName} ${sessionScope.user.lastName} </h1>
<%@ include file="/WEB-INF/fragment/task.jspf" %>
</body>
<%@ include file="/WEB-INF/fragment/script.jspf" %>
<%@ include file="/WEB-INF/fragment/footer.jspf" %>
</html>
