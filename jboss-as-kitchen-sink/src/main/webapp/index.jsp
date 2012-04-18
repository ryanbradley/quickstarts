<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Java EE 6 Starter Application</title>
	</head>

	<body>
		<div id="header">
			<h1>Welcome to JBoss!</h1>
		</div>

		<div id="subheader">
			<p>You have successfully deployed a Java EE 6 web application.</p>
			<h3>Your application can run on:</h3>
			<img src="resources/dualbrand_as7eap.png">
		</div>
	
		<div id="reg">
			<h2>Member Registration</h2>
			<p>Enforces annotation-based constraints defined on the model class</p>
			<form:form commandName="member">
				<table>
					<tbody>
						<tr>
							<th><form:label path="name">Name:</form:label></th>
							<td><form:input path="name"/></td>
							<td/>
						</tr>
						<tr>
							<th><form:label path="email">Email:</form:label></th>
							<td><form:input path="email"/></td>
							<td/>
						</tr>
						<tr>
							<th><form:label path="phoneNumber">Phone #:</form:label>
							<td><form:input path="phoneNumber"/></td>
							<td/>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="Register"/>
			</form:form>
		</div>

		<div id="members">
			<h2>Members</h2>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone #</th>
						<th>REST URL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${members}" var="member">
						<tr>
							<td>${member.id}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
							<td>${member.phoneNumber}</td>
							<td><a href="/members/${member.id}">/members/${member.id}</a></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div id="footer">
			REST URL for all members: <a href="/members">/members</a>
		</div>
	</body>
</html>
