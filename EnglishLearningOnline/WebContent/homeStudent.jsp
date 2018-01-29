<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>English Learning Online System</title>

<!-- Bootstrap core CSS -->
<!-- <link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css' rel='stylesheet'/>  -->

<!-- Custom styles for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900"
	rel="stylesheet">
<link href="plus/blog.css" rel="stylesheet">
<link href="plus/bootstrap.css" rel="stylesheet">
<link href="plus/bootstrap.min.css" rel="stylesheet">
</head>
<%@page import="jdbc.DbUtil" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>

<%
	
    session=request.getSession(false);
    if(session.getAttribute("userName")==null)
    {
        response.sendRedirect("index.jsp");
    }
	String userName = session.getAttribute("userName").toString();
// 	get Enrolled courses
	String sql = "SELECT c.coursename, c.courseid FROM db_englishlearningonline.tb_section sc, db_englishlearningonline.tb_course c "
			+"WHERE sc.courseid = c.courseid AND sc.userid =" 
			+"(SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"+userName+"' LIMIT 1)";
//  get Avialable courses
	String sql1 ="SELECT c.coursename, c.courseid FROM db_englishlearningonline.tb_course c "+
	"WHERE c.courseid NOT IN (SELECT sc.courseid FROM db_englishlearningonline.tb_section sc "+
	"WHERE sc.userid = (SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"+userName+"' LIMIT 1))";

// get Comments
	String sql2 = "SELECT L.*, c.coursename FROM "+ 
	        "(SELECT * FROM db_englishlearningonline.tb_feedback f "+
			"WHERE f.userid = (SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"+userName+"' LIMIT 1) "+
			"UNION	ALL "+		
			"SELECT * FROM db_englishlearningonline.tb_feedback f1 "+
			"WHERE f1.replyfeedbackid IN ( "+
			"SELECT f2.feedbackid FROM db_englishlearningonline.tb_feedback f2 "+
			"WHERE f2.userid = (SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"+userName+"' LIMIT 1)) "+
			") L, db_englishlearningonline.tb_course c WHERE c.courseid = L.courseid ORDER BY L.createdtime DESC";
	
	Connection conn = DbUtil.getConnection();
	//enrolled courses
	PreparedStatement ps = conn.prepareStatement(sql);
	PreparedStatement ps1 = conn.prepareStatement(sql);
	PreparedStatement ps3 = conn.prepareStatement(sql);
	//AV courses
	PreparedStatement ps2 = conn.prepareStatement(sql1);
	//comments
	PreparedStatement ps4 = conn.prepareStatement(sql2);
	
	ResultSet rs = ps.executeQuery();
	ResultSet rs1 = ps1.executeQuery();
	ResultSet rs3 = ps3.executeQuery();
	ResultSet rs2 = ps2.executeQuery();
	ResultSet rs4 = ps4.executeQuery();
	
%>
<body>

	<div class="container">
		<header class="blog-header py-3">
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1"></div>
				<div class="col-4 text-center">
					<a class="blog-header-logo text-dark" href="#">English Learning
						Online System</a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center">

					<div class="control-group">
						<p><%= userName %></p>
						<a class="btn btn-sm btn-outline-secondary" href="index.jsp">Log
							out</a>
					</div>
				</div>
			</div>
		</header>

		<div class="nav-scroller py-1 mb-2">
			<nav class="nav d-flex justify-content-between">
				<a class="p-2 text-muted" href="#download">Download Materials</a> <a
					class="p-2 text-muted" href="#enroll">Enroll Course</a> <a
					class="p-2 text-muted" href="#feed">Feedbacks</a>
			</nav>
		</div>
		<hr>



		<main role="main" class="container">
		<div class="row">
			<div class="col-md-8 blog-main">
				<div class="card">
					<div class="card-body" id="download">
						<h5 class="card-title">Download Study Materials</h5>
						<form class="needs-validation card-text" action = "materials.jsp" method = "post" >
							<div class="col-md-4 mb-3">
								<label for="state">Choose Course</label>
								<input type="hidden" id="thisField" name="userName" value="<%=userName %>"> 
								<select
									class="custom-select d-block w-100" id="state" name = "courseId" required>
									<% while(rs.next()){
										%>
										<option value="<%=rs.getString("courseid") %>"><%=rs.getString("coursename") %></option>	
										<%
									}%>
									
								</select>
							</div>
							<hr class="mb-4">
							<button class="btn btn-outline-secondary btn-lg btn-block"
								type="submit">Download</button>
						</form>
					</div>
				</div>
				<hr>
				<div class="card">
					<div class="card-body" id = "enroll">

						<h5 class="card-title">Enroll Course</h5>
						<form class="needs-validation card-text" action = "HomeStudent" method = "post">
							<div class="mb-3">
								<label for="country">Choose Course</label>
								<input type="hidden" id="thisField" name="userName" value="<%=userName %>">
								<input type="hidden" id="thisField" name="formType" value="Enroll">
								<div class="input-group">
									<select class="custom-select d-block w-100" id="country" name="courseId"
										required>
										<% while(rs2.next()){
										%>
										<option value="<%=rs2.getString("courseid") %>"><%=rs2.getString("coursename") %></option>	
										<%
									}%>
									</select>

								</div>
							</div>
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="same-address" required> <label class="custom-control-label"
									for="same-address">I accept the License and User
									Agreement of English Learning Online System</label>
							</div>

							<hr class="mb-4">
							<button class="btn btn-outline-secondary btn-lg btn-block"
								type="submit">Enroll Course</button>
						</form>

					</div>
				</div>
				<hr>

				<div class="card" id = "feed">
					<div id="accordion">
						<div class="card">
							<div class="card-header" id="headingOne">
								<h5 class="mb-0">
									<button class="btn btn-link" data-toggle="collapse"
										data-target="#collapseOne" aria-expanded="false"
										aria-controls="collapseOne">Give Feedback</button>
								</h5>
							</div>

							<div id="collapseOne" class="collapse show"
								aria-labelledby="headingOne" data-parent="#accordion">
								<div class="card-body">
									<form action = "HomeStudent" method = "post">
										<div class="form-group">
											<label for="exampleFormControlSelect1">Select Course</label>
											<input type="hidden" id="thisField" name="userName" value="<%=userName %>">
											<input type="hidden" id="thisField" name="formType" value="Feedback">
											<select class="form-control" id="exampleFormControlSelect1" name ="CourseIDFeed">
												<% while(rs3.next()){
										%>
										<option value="<%=rs3.getString("courseid") %>"><%=rs3.getString("coursename") %></option>	
										<%
									}%>
											</select>
										</div>
										<div class="form-group">
											<label for="exampleFormControlTextarea1">Comment</label>
											<textarea class="form-control"
												id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>
										</div>
										<hr class="mb-4">
							<button class="btn btn-outline-secondary btn-lg btn-block"
								type="submit">Give</button>
									</form>
								</div>
							</div>
						</div>
						<div class="card">
							<div class="card-header" id="headingTwo">
								<h5 class="mb-0">
									<button class="btn btn-link collapsed" data-toggle="collapse"
										data-target="#collapseTwo" aria-expanded="false"
										aria-controls="collapseTwo">Read Feedbacks</button>
								</h5>
							</div>
							<div id="collapseTwo" class="collapse"
								aria-labelledby="headingTwo" data-parent="#accordion">
									<% while(rs4.next()){
										%>
										<form class="needs-validation card-text">
										<div class="card-body">
										<div class="card mb-4 box-shadow">
											<div class="card-header">
												<h5 class="my-0 font-weight-normal">
													<%=rs4.getString("username") %> <small class="text-muted"><%=rs4.getString("createdtime") %> -
														<%=rs4.getString("coursename") %></small>
														<% if (rs4.getString("replyfeedbackid")!=null) { %> 
     															<strong class="d-inline-block mb-2 text-primary">Reply</strong>
   														<% } %>
												</h5>
											</div>
											<div class="card-body">
												<p><%=rs4.getString("content") %></p>
											</div>
										</div>
										</div>
										</form>
										<%
									}%>
									
								
						</div>
					</div>
				</div>
			</div>
			<hr>
		</div>


		<aside class="col-md-4 blog-sidebar">
			<div class="p-3 mb-3 bg-light rounded">
				<p class="mb-0">The Heart is your student, for love is the only
					way we learn.</p>
			</div>

			<div class="p-3">
				<h4 class="font-italic">Enrolled courses</h4>
				<ol class="list-unstyled mb-0">
					<% while(rs1.next()){
						%>
						<li><a href="#"><%=rs1.getString("coursename") %></a></li>	
						<%
					}%>
					
				</ol>
			</div>

			<div class="p-3">
				<h4 class="font-italic">Contact us</h4>
				<ol class="list-unstyled">
					<li><a href="#">GitHub</a></li>
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Facebook</a></li>
				</ol>
			</div>
		</aside>
		<!-- /.blog-sidebar -->
	</div>
	<!-- /.row -->
	</main>
	<!-- /.container -->

	<footer class="blog-footer">
		<p>
			We are using this template <a href="https://getbootstrap.com/">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')
	</script>


	<script src="../../../../assets/js/vendor/holder.min.js"></script>
	<script src="plus/bootstrap.min.js"></script>
	<script>
		Holder.addTheme('thumb', {
			bg : '#55595c',
			fg : '#eceeef',
			text : 'Thumbnail'
		});
	</script>
</body>
</html>
