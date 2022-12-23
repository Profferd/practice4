<%--
  Created by IntelliJ IDEA.
  User: dgrus
  Date: 12/23/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <jsp:include page="headerLink.jsp"/>
</head>
<header>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="textResources.textResources" var="local"/>

    <form action=${pageContext.request.contextPath}/practice4 method="get">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary" style="font-size: 20px">

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/practice4?command=home">
                            <fmt:message bundle="${local}" key="home"/>
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <c:choose>
                        <c:when test="${sessionScope.user == null}">
                            <li class="nav-item">
                                <button class="btn btn-secondary my-2 my-sm-0" type="submit" name="command"
                                        value="login">
                                    <fmt:message bundle="${local}" key="log.in"/>
                                </button>
                            </li>
                        </c:when>
                        <c:when test="${sessionScope.user != null}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="userDropdown" data-bs-toggle="dropdown" href="#"
                                   role="button"
                                   aria-haspopup="true" aria-expanded="false">
                                        ${sessionScope.user}
                                </a>
                                <div class="dropdown-menu" aria-labelledby="userDropdown">
                                    <a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/practice4?command=userList">
                                        <fmt:message bundle="${local}" key="user.list"/></a>

                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/practice4?command=logout">
                                        <fmt:message bundle="${local}" key="log.Out"/></a>
                                </div>
                            </li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </nav>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</header>

