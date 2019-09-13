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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<h3>${formMode}&nbsp;Customer</h3>

		<form:form action="${formModeLowercase}Customer"
			modelAttribute="customer" method="post">

			<table>

				<tbody>

					<c:choose>
						<c:when test="${not empty showId && showId}">
							<tr>
								<td><label for="id">Customer id:</label></td>
								<td><form:input path="id" readonly="true" /></td>
							</tr>
						</c:when>
						<c:otherwise>
							<form:hidden path="id" />
						</c:otherwise>
					</c:choose>
					<form:errors path="id" />

					<tr>
						<td><label for="firstName">First name:</label></td>
						<td><form:input path="firstName" /> <form:errors
								path="firstName" /></td>
					</tr>

					<tr>
						<td><label for="lastName">Last name:</label></td>
						<td><form:input path="lastName" /> <form:errors
								path="lastName" /></td>
					</tr>

					<tr>
						<td><label for="email">Email:</label></td>
						<td><form:input path="email" /> <form:errors path="email" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="${formMode}" class="save" /></td>
					</tr>

				</tbody>

			</table>

			<br>

			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back
					to List</a>
			</p>

		</form:form>

	</div>

</body>
</html>