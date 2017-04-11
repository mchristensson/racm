<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>RACI App</title>

<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Project Name</a>
		</div>
	</div>
</nav>
hello

<c:forEach items="${users}" var="user">
             <tr>
                 <td>${user.firstName}</td>
                 <td>${user.lastName}</td>
                 <td>${user.email}</td>
                 <td>${user.ssoId}</td>
                 <td>EDIT</td>
                        <td>DEL.</td>
                    </tr>
                </c:forEach>

</body>