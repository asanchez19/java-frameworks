<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Users</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Users</h1>
            <p>All the available users</p>
            <p>
                <a href="<spring:url value="/users/add" />"
                   class="btn btn-default"> <span
                        class="glyphicon glyphicon-new-window"></span> New User
                </a>
            </p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${users}" var="user">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${user.firstName} ${user.lastName}</h3>
                        <p>${user.email}</p>
                        <p>
                            <a
                                    href=" <spring:url value="/user?id=${user.id}" /> "
                                    class="btn btn-primary"> <span
                                    class="glyphicon-info-sign glyphicon" /></span> Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
