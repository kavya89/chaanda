<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="edu.neu.cs5200.chaanda.models.*,edu.neu.cs5200.chaanda.dao.*,java.util.*,java.math.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Landing</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style>
#element1 {
	float: right;
	margin-right: 15px;
}

#element2 {
	float: right;
}
body {
	background:
		url(http://download.free-download-web.com/files/2014/09/Cartoon-study-article-vector-material-2.jpg)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>
<body>
	<h2>
		<%
			String userName = session.getAttribute("userName").toString();
			Integer personId = Integer.parseInt(session
					.getAttribute("personId").toString());
			StudentDAO dao = new StudentDAO();

			UniversityDAO uDao = new UniversityDAO();

			University u = uDao.getUniversityforadmin(personId);

			//String action = request.getParameter("action");

			if((request.getParameter("deleteStudentId") !=null) && !(request.getParameter("deleteStudentId").isEmpty() )){
				dao.deletePerson(Integer.parseInt(request.getParameter("deleteStudentId")));
			}
		%>
	</h2>
	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<a href="UniversityLogin.jsp" class="navbar-brand"><%=u.getUniversityName()%></a>
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="UniversityLogin.jsp">Home</a></li>
					<li><a href="Logout.jsp">Logout</a></li>
				</ul>
			</div>
		</div>
	</div>
	<h4 id="element2">
		<%
			out.println("Hello  " + userName);
		%>
	</h4>
	<br />
	<form action="AdminLanding.jsp">
		<div class="container">
		<%

			List<Student> studentsApproved = dao.getStudentsApproved(u
					.getUniversityId()); 
		%>

	<h3> Add new student</h3>
		
	<br><br><br>
		<h3>List of students being funded</h3>

		<%
			if (studentsApproved.size() == 0) {
		%>
		<h4>No students have requested funding</h4>
		<%
			} else {
		%>
		<table class="table table-striped">
			<tr>
				<td>Student name</td>
				<td>Tuition fee Required</td>
				<td>Tuition fee Collected</td>
				<td>Tuition fee to be collected</td>
			</tr>

			<%
				for (Student s : studentsApproved) {
			%>
			<tr>
				<td><a
					href="StudentDetails.jsp?studentId=<%=s.getPerson().getPersonId()%>"><%=s.getPerson().getPersonName()%></a></td>
				<td><%=s.getStudentfunddetail().getFundRequired()%></td>
				<td><%=s.getStudentfunddetail().getFundCollected()%></td>
				<td><%=s.getStudentfunddetail().getFundRequired()
							.subtract(s.getStudentfunddetail().getFundCollected())%></td>
							<td><a class="btn btn-warning" name=action value="delete"
						href="AdminLanding.jsp?deleteStudentId=<%=s.getPerson().getPersonId()%>">Delete from chaanda</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		</div>
	</form>
</body>
</html>