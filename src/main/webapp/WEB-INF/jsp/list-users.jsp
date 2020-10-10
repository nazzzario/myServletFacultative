<%@ include file="/WEB-INF/fragment/directive/taglib.jspf" %>

<html>

<%--<fmt:message key="users.title" var="users_title"/>--%>
<%--<c:set var="title" scope="request" value="${users_title}"/>--%>
<head>
    <%@ include file="/WEB-INF/fragment/script.jspf" %>
    <%@ include file="/WEB-INF/fragment/head.jspf" %>
</head>

<header>
    <%@ include file="/WEB-INF/fragment/navbar.jspf" %>
</header>

<body>

<section id="tabs" class="project-tab">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <nav>
                    <div class="nav nav-tabs nav-fill " id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home" data-toggle="tab" href="#students" role="tab"
                           aria-controls="nav-profile" aria-selected="true">Students</a>



                        <a class="nav-item nav-link " id="nav-home-tab" data-toggle="tab" href="#teachers"
                           role="tab" aria-controls="nav-profile-tab" aria-selected="false">Teachers</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="students" role="tabpanel" aria-labelledby="nav-profile-tab">
                        <table class="table" cellspacing="0">
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
                            <c:forEach var="student" items="${requestScope.students}">
                                <tr>
                                    <td>${student.login}</td>
                                    <td>${student.userRole}</td>
                                    <td>${student.firstName}</td>
                                    <td>${student.lastName}</td>
                                    <td>${student.blocked}</td>
                                    <td>
                                        <c:choose>
                                        <c:when test="${student.blocked}">
                                    <td>
                                        <form method="post" action="controller">
                                            <input type="hidden" name="command" value="unblock-student"/>
                                            <input type="hidden" name="usr_id" value="${student.id}">
                                            <fmt:message key="usr.unblock" var="unblock_user"/>
                                            <input type="submit" value="${unblock_user}">
                                        </form>
                                    </td>
                                    </c:when>
                                    <c:when test="${!student.blocked}">
                                        <td>
                                            <form method="post" action="controller">
                                                <input type="hidden" name="command" value="block-student"/>
                                                <input type="hidden" name="usr_id" value="${student.id}">
                                                <fmt:message key="usr.block" var="block_user"/>
                                                <input type="submit" value="${block_user}">
                                            </form>
                                        </td>
                                    </c:when>
                                    </c:choose>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade" id="teachers" role="tabpanel" aria-labelledby="nav-home-tab">
                        <table class="table" cellspacing="0">
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
                            <c:forEach var="teacher" items="${requestScope.teachers}">
                                <tr>
                                    <td>${teacher.login}</td>
                                    <td>${teacher.userRole}</td>
                                    <td>${teacher.firstName}</td>
                                    <td>${teacher.lastName}</td>
                                    <td>${teacher.blocked}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/fragment/footer.jspf" %>
</body>
</html>

