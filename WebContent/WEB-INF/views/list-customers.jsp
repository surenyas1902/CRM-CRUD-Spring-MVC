<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Customer button -->
			<input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;"
				class="add-button"/>
			
			<table>
				<thead>
					<tr>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Email</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="eachCustomerRow" items="${customers}">
					
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${eachCustomerRow.rowId}"/>
						</c:url>
						<tr>
							<td>${eachCustomerRow.firstName}</td>
							<td>${eachCustomerRow.lastName}</td>
							<td><a href="mailto:${emailAddress}">${eachCustomerRow.emailAddress}</a></td>
							<td>
								<a href="${updateLink}">Update</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>