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
            <div class="card-columns justify-content-center">
                <c:forEach var="course" items="${requestScope.catalogCourse}">
                    <div class="card" style="width: 18rem;">

                        <div class="card-body">
                            <h5 class="card-title">${course.courseName}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${course.teacherName}</h6>
                            <h6 class="card-subtitle mb-2 text-muted">${course.subjectName}</h6>
                            <p class="card-text">${course.startDate} ${course.endDate}</p>
                            <c:if test="${sessionScope.user_role != null}">
                                <a href="#" class="btn btn-primary"><fmt:message key="course.join"/> </a>
                            </c:if>

                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<%@ include file="/WEB-INF/fragment/footer.jspf" %>
</body>
</html>
