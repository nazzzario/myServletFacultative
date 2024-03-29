<%@ include file="/WEB-INF/fragment/directive/taglib.jspf" %>
<!DOCTYPE>
<%@ include file="/WEB-INF/fragment/head.jspf" %>

<body>
<div class="container">

    <div class="form-container">
        <form method="post" action="controller">
            <input type="hidden" name="command" value="add-student">

            <div class="form-field">
                <label for="login"><fmt:message key="label.username"/></label<br><br>
                <input id="login" type="text" name="login" required>
            </div>
            <div class="form-field">
                <label for="password"><fmt:message key="user.password"/></label><br>
                <input id="password" type="text" name="password" required>
            </div>
            <div class="form-field">
            </div>
            <div class="form-field">
                <label for="first_name"><fmt:message key="usr.firstname"/></label><br>
                <input id="first_name" name="first_name" required>
            </div>
            <div class="form-field">
                <label for="last_name"><fmt:message key="usr.lastname"/></label><br>
                <input id="last_name" name="last_name" required>
            </div>

            <fmt:message key="btn.submit" var="submit"/>
            <button type="submit"  value="${submit}">Submit</button>
        </form>
        <fmt:message key="login.page" var="login"/>
        <div><a href="controller?command=login">${login}</a></div>
    </div>
    <div>
        <%@ include file="/WEB-INF/fragment/locale.jspf" %>
    </div>
</div>
</body>
<%@ include file="/WEB-INF/fragment/script.jspf" %>
</html>
