<%--
  Created by IntelliJ IDEA.
  User: dgrus
  Date: 12/23/2022
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Log In</title>
    <jsp:include page="../fragments/headerLink.jsp"/>
</head>
<body>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="textResources.textResources" var="local"/>

<div class="container">
    <div class="row justify-content-center">
        <div class="col"></div>
        <div class="col-6 my-sm-3">
            <c:if test="${sessionScope.user != null}">
                <div class="alert alert-danger fade show " role="alert">
                    <fmt:message bundle="${local}" key="Logged.In"/>
                </div>
            </c:if>
            <c:if test="${sessionScope.user == null}">

                <h1 class="mt-5 fw-bold"><fmt:message bundle="${local}" key="sing.in"/></h1>

                <c:if test="${errorMessage=='true'}">
                    <div class="alert alert-danger fade show" role="alert">
                        <fmt:message bundle="${local}" key="error.login"/>
                    </div>
                </c:if>

                <form action="${pageContext.request.contextPath}/practice4?command=checkLogin" method="post">
                    <div class="mb-3">
                        <div class="input-group w-100">
                            <input name="login" type="text" class="form-control"
                                   aria-describedby="loginHelp" placeholder="Login">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="passwordInput" class="form-label"><fmt:message bundle="${local}"
                                                                                   key="user.password"/></label>
                        <div class="input-group w-100">
                            <input name="password" type="password" class="form-control" id="passwordInput"
                                   placeholder="password">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary"><fmt:message bundle="${local}" key="sing.in"/></button>
                </form>
                <hr class="dropdown-divider">
            </c:if>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
