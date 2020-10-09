<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setBundle basename="messages"/>

<html>

<fmt:message key="login.title" var="login_title"/>
<c:set var="title" scope="request" value="${login_title}"/>
<body>


<div class="container">

    <div class="login-container">
        <c:if test="${not empty error}">
            <div class="error-wrap">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <form method="post" action="controller">
            <input type="hidden" name="command" value="Login">

            <div>
                <div class="login-field">
                    <label for="login"><fmt:message key="login.login"/></label><br>
                    <fmt:message key="regex.title.login" var="regex_login_title"/>
                    <input id="login" type="text" name="login" title="${regex_login_title}" required>
                </div>
                <div class="login-field">
                    <label for="password"><fmt:message key="login.password"/></label><br>
                    <fmt:message key="regex.title.password" var="regex_password_title"/>
                    <input id="password" type="password" name="password" title="${regex_password_title}" required>
                </div>

                <fmt:message key="b" var="submit"/>
                <input type="submit" value="${submit}"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
