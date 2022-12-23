<%--
  Created by IntelliJ IDEA.
  User: dgrus
  Date: 12/23/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="../fragments/header.jsp"/>
<head>
    <title>List of users</title>
    <jsp:include page="../fragments/headerLink.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="textResources.textResources" var="local"/>

<form action=${pageContext.request.contextPath}/practice4 method="post">
    <div class="container">
        <c:if test="${sessionScope.user == null}">
            <div class="row justify-content-center">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${local}" key="userList.noAccess"/>
                </div>
            </div>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <div class="my-sm-3">
                <div class="row justify-content-center">
                    <c:if test="${userList.size() <= 0}">
                        <h4 class="text-muted"><fmt:message bundle="${local}" key="user.empty"/></h4>
                    </c:if>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col"><fmt:message bundle="${local}" key="user.login"/></th>
                            <th scope="col"><fmt:message bundle="${local}" key="user.name"/></th>
                        </tr>
                        </thead>
                        <c:forEach var="user" items="${userList}">
                            <tr>
                                <td>
                                    ${user.login}
                                </td>
                                <td>
                                    ${user.name}
                                </td>

                        </c:forEach>
                    </table>
                </div>
            </div>
        </c:if>
    </div>
</form>
</body>
</html>
