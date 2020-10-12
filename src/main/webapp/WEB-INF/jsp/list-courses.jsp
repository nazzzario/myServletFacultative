<%@ include file="/WEB-INF/fragment/directive/taglib.jspf" %>

<html>

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
                        <a class="nav-item nav-link active" id="nav-home" data-toggle="tab" href="#courses" role="tab"
                           aria-controls="nav-profile" aria-selected="true">Courses</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="courses" role="tabpanel"
                         aria-labelledby="nav-profile-tab">
                        <table class="table" cellspacing="0">
                            <thead>
                            <tr>
                                <th><fmt:message key="course.name"/></th>
                                <th><fmt:message key="course.start.date"/></th>
                                <th><fmt:message key="course.end.date"/></th>
                                <th><fmt:message key="course.teacher"/></th>
                                <th><fmt:message key="course.status"/></th>
                                <th><fmt:message key="course.subject"/></th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="course" items="${requestScope.courses}">
                                <tr>
                                    <td>${course.courseName}</td>
                                    <td>${course.startDate}</td>
                                    <td>${course.endDate}</td>
                                    <td>${course.teacherName}</td>
                                    <td>${course.courseStatus}</td>
                                    <td>${course.subjectName}</td>
                                    <td>
                                        <form method="get" action="controller">
                                            <input type="hidden" name="command" value="edit-course"/>
                                            <input type="hidden" name="course_id" value="${course.id}">
                                            <fmt:message key="course.edit" var="course_edit"/>
                                            <input type="submit" value="${course_edit}">
                                        </form>
                                    </td>
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

