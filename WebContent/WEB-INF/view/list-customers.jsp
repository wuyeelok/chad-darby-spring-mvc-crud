<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

			<!-- Add a search button -->
			<form:form action="search" method="post">
				<label for="theSearchName">Search customer:</label>
				<input type="text" id="theSearchName" name="theSearchName"
					placeholder="Blank for search all" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<!--  add out html table here -->
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				</tbody>
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- Construct an "update" link with customer id -->
					<c:url var="updateLink" value="showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<!-- Construct a "delete" link with customer id -->
					<c:url var="deleteLink" value="deleteCustomer">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.id}</td>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a>&nbsp;|&nbsp;<a
							class="deleteLink" href="${deleteLink}">Delete</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

		</div>

	</div>

	<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>