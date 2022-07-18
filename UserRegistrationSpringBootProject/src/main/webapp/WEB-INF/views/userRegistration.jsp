<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- UI pagination -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">

<!-- Use for Pagination on UI data table links -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>

</head>
<body>
	<div class="container mt-5 text-danger">
		<div class="display-4">User Form</div>
		<form action="./saveuserForm" method="post" class="form-group">
			<input type="hidden" name="userId" id="userId" value="${myUser.userId }">
			<div class="row">
				<div class="col-sm-4">
					<label class="text-primary">User Name</label> <input type="text"
						name="userName" id="nameid" class="form-control"
						value="${myUser.userName }">
				</div>
				<div class="col-sm-4">
					<label class="text-primary">Email</label> <input type="text"
						name="email" id="emailid" class="form-control"
						value="${myUser.email }">
				</div>
				<div class="col-sm-4 mt-2">
					<label class="text-primary">Phone No</label> <input type="text"
						name="phone" id="phone" class="form-control" value="${myUser.phone }">
				</div>
				<div class="col-sm-4">
					<label for="roleId" class="text-primary">Role Name</label> <select
						name="myRole" class="form-control" id="role_id">
						<option value="0">--select--</option>
						<c:forEach items="${allroles }" var="role">
							<option value="${role.roleId }"
								<c:if test="${role.roleId eq myUser.myRole.get(0).roleId }">selected='selected'</c:if>>${role.roleName }</option>
						</c:forEach>
					</select>
				</div>

			</div>
			<div class="text-center">
				<!-- <input type="submit" value="save" class="btn btn-success mt-2"> -->
				<c:if test="${myUser eq null }">
					<input type="submit" value="save" class="btn btn-success mt-2">
				</c:if>
				<c:if test="${myUser ne null }">
					<input type="submit" value="Update" class="btn btn-success mt-2">
				</c:if>
			</div>
		</form>
	</div>
	<div class="container mt-5 text-danger">
		<div class="display-4">User Form</div>
		<hr>
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>sl No</th>
					<th>User Id</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Phone No</th>
					<th>User Type</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${AllActiveList.size() ne 0 }">
						<c:forEach items="${AllActiveList }" varStatus="count" var="user">
							<tr>
								<td>${count.count }</td>
								<td>${user.userId }</td>
								<td>${user.userName }</td>
								<td>${user.email }</td>
								<td>${user.phone }</td>
								<td>${user.myRole.get(0).roleName }</td>

								<td><a class="btn btn-danger"
									href="./updateUser?userId=${user.userId }">Update</a>&nbsp;&nbsp;&nbsp;<a
									class="btn btn-success"
									href="./deleteUser?userId=${user.userId}">Delete</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" align="center"><strong class="text-danger">No
									record found</strong></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>