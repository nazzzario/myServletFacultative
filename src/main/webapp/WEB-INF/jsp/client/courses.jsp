<%--
  Created by IntelliJ IDEA.
  User: krasn
  Date: 9/25/2020
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<html>

<body>
<tr>
    <td class="content">
        <%-- CONTENT --%>

        <form id="make_order" action="controller">
            <input type="hidden" name="command" value="makeOrder"/>

            <table id="list_menu_table">
                <c:set var="k" value="0"/>
                <jsp:useBean id="courseList" scope="request" type="java.util.List"/>
                <c:forEach var="item" items="${courseList}">
                    <c:set var="k" value="${k+1}"/>
                    <tr>
                        <td><c:out value="${k}"/></td>
                        <td>${item.courseName}</td>
                        <td>${item.startDate}</td>
                        <td>${item.endDate}</td>
                        <td>${item.description}</td>
                        <td>${item.status}</td>
                    </tr>
                </c:forEach>
            </table>

        </form>

        <%-- CONTENT --%>
    </td>
</tr>
</body>
</html>
