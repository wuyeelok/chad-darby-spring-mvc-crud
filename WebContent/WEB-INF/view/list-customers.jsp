<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>

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

			<!-- Put new button: Add Customer -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />

			<!--  add out html table here -->
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				</tbody>
				<c:forEach items="${customers}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.firstName}</td>
						<td>${c.lastName}</td>
						<td>${c.email}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>

	</div>

</body>
</html>