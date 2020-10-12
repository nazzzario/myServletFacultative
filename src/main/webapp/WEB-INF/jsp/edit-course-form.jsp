<%@ page contentType="text/html;charset=UTF-8" %>
<%--<fmt:setBundle basename="messages"/>--%>

<!DOCTYPE>
<html>
<head>
    <%@ include file="/WEB-INF/fragment/head.jspf" %>
</head>
<header>
    <%@ include file="/WEB-INF/fragment/navbar.jspf" %>
</header>

<body>
<div class="row justify-content-center">
    <div class="col-md-8">
        <div class="card">
            <fmt:message key="course.edit" var="course_edit"/>
            <div class="card-header">
                ${course_edit}
            </div>
            <div class="card-body">
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="edit-course">
                    <input type="hidden" name="course_id" value="${requestScope.course.id}">
                    <%--                    <div class="alert alert-danger" th:if="${#fields.hasErrors('*')}">--%>
                    <%--                        <p th:each="err : ${#fields.errors('*')}" th:text="${err}"></p>--%>
                    <%--                    </div>--%>

                    <div class="form-group row">
                        <label class="col-md-4 col-form-label text-md-right"><fmt:message key="course.name"/></label>
                        <div class="col-md-6">
                            <input class="form-control" type="text" name="course_name" value="${requestScope.course.courseName}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-4 col-form-label text-md-right"><fmt:message
                                key="course.start.date"/></label>
                        <div class="col-md-6">
                            <input type="date" class="form-control" name="start_date" value="${requestScope.course.startDate}"/>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label class="col-md-4 col-form-label text-md-right"><fmt:message
                                key="course.end.date"/></label>
                        <div class="col-md-6">
                            <input type="date" class="form-control" name="end_date" value="${requestScope.course.endDate}"/>
                        </div>
                    </div>

                    <div class="form-row justify-content-center">
                        <div class="col-sm-3">
                            <label for="subject"><fmt:message key="course.subject"/></label><br>
                            <select id="subject" name="subject_id" class="form-control" required>
                                <c:forEach var="subject" items="${requestScope.subjects}">
                                    <option value="${subject.id}">${subject.subjectName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-sm-3">
                            <label for="teacher"><fmt:message key="course.teacher"/></label><br>
                            <select id="teacher" name="teacher_id" class="form-control" required>
                                <c:forEach var="teacher" items="${requestScope.teachers}">
                                    <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <fmt:message key="btn.submit" var="submit"/>
                    <input type="submit" value="${submit}"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/fragment/script.jspf" %>
<%@ include file="/WEB-INF/fragment/footer.jspf" %>
</html>
