<%@ include file="/WEB-INF/fragment/directive/taglib.jspf" %>

<html>
<head>
    <%@ include file="/WEB-INF/fragment/head.jspf" %>
    <title>
        <fmt:message key="label.login" var="login_title"/>
        <c:set var="title" scope="request" value="${login_title}"/>
    </title>
</head>

<body>
<%@ include file="/WEB-INF/fragment/locale.jspf" %>
<div class="container">

    <div class="login-container">
        <%--        <c:if test="${not empty error}">--%>
        <%--            <div class="error-wrap">--%>
        <%--                <c:out value="${error}"/>--%>
        <%--            </div>--%>
        <%--        </c:if>--%>
        <form method="post" action="controller">
            <input type="hidden" name="command" value="login">

            <div>
                <div class="login-field">
                    <label for="login"><fmt:message key="label.username"/></label><br>
                    <input id="login" type="text" name="login" required>
                </div>
                <div class="login-field">
                    <label for="password"><fmt:message key="user.password"/></label><br>
                    <input id="password" type="password" name="password" required>
                </div>

                <fmt:message key="btn.submit" var="submit"/>
                <input type="submit" value="${submit}"/>
            </div>
            <fmt:message key="create.account" var="create"/>
            <div><a href="controller?command=add-student">${create}</a></div>
        </form>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/fragment/script.jspf" %>
<%@ include file="/WEB-INF/fragment/footer.jspf" %>
</html>
