<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${formMode}&nbsp;Customer</title>

<!-- Reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<h3>${formMode}&nbsp;Customer</h3>

			<form:form method="post" action="customer${formMode}"
				modelAttribute="customer">
				<c:choose>
					<c:when test="${not empty showId && showId}">
						<label for="id">Customer id:</label>
						<form:input path="id" readonly="true" />
						<br>
					</c:when>
					<c:otherwise>
						<form:hidden path="id" />
					</c:otherwise>
				</c:choose>
				<form:errors path="id" />

				<label for="firstName">First name:</label>
				<form:input path="firstName" />
				<form:errors path="firstName" />
				<br>

				<label for="lastName">Last name:</label>
				<form:input path="lastName" />
				<form:errors path="lastName" />
				<br>

				<label for="email">Email:</label>
				<form:input path="email" />
				<form:errors path="email" />
				<br>

				<input type="submit" value="${formMode}" />
			</form:form>

		</div>

	</div>

</body>
</html>