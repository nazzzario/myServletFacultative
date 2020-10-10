<%@ include file="/WEB-INF/fragment/directive/taglib.jspf" %>

<html>

<%--<fmt:message key="users.title" var="users_title"/>--%>
<%--<c:set var="title" scope="request" value="${users_title}"/>--%>
<%@ include file="/WEB-INF/fragment/head.jspf" %>

<header>
    <%@ include file="/WEB-INF/fragment/navbar.jspf" %>
</header>

<body>
<div class="container">

    <div class="content">
        <table class="table">
            <thead>
            <tr>
                <th><fmt:message key="user.username"/></th>
                <th><fmt:message key="usr.role"/></th>
                <th><fmt:message key="usr.firstname"/></th>
                <th><fmt:message key="usr.lastname"/></th>
                <th><fmt:message key="usr.block"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${requestScope.users}">
                <tr>
                    <td>${user.login}</td>
                    <td>${user.userRole}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.blocked}</td>
                    <td>
<%--                        <form method="post" action="controller">--%>
<%--                            <input type="hidden" name="command" value="DeleteUser"/>--%>
<%--                            <input type="hidden" name="user_id" value="${user.id}">--%>
<%--                            <fmt:message key="user.delete_user" var="delete_user"/>--%>
<%--                            <input type="submit" value="${delete_user}"/>--%>
<%--                        </form>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>