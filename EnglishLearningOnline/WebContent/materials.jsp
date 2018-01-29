<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="daos.MaterialDao" %>
<%@page import="models.Material" %>
<%@page import="java.util.List" %>
<%
	String userName =request.getParameter("usnerName");
	String courseId =request.getParameter("courseId");
	
	if(courseId==null)
	    response.sendRedirect("index.jsp");
	
	MaterialDao md = new MaterialDao();
	List<Material> allMats = md.getAllMaterialsByCourse(userName, courseId);

%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>English Learning Online System</title>

    <!-- Bootstrap core CSS -->
    <!-- <link href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css' rel='stylesheet'/>  -->
	
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="plus/blog.css" rel="stylesheet">
    <link href="plus/bootstrap.css" rel="stylesheet">
    <link href="plus/bootstrap.min.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
		<header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-4 pt-1">
          </div>
          <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="#">English Learning Online System</a>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
          	
            	</div>
          </div>
        </div>
      </header>

      

    </div>  
    <main role="main" class="container">
      <div class="row">
        <div class="col-md-12 order-md-2 mb-12">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Download Materials</span>
            <span class="badge badge-secondary badge-pill"><%=allMats.size() %></span>
          </h4>
          <ul class="list-group mb-3">
           <% for( int i = 0; i< allMats.size(); i++){
						%>
						<li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0"><%=allMats.get(i).getMaterialName() %></h6>
                <small class="text-muted">uploaded on : <%=allMats.get(i).getUploadedtime() %> </small>
              </div>
              <span class="text-muted">file extension: <%=allMats.get(i).getFiletype() %></span>
              <button type="button" class="btn btn-outline-success" onclick="window.open('file://<%=allMats.get(i).getFileurl() %>')">Download</button>
            </li>
						<%
					}%>
            
            
            
          </ul>

          
        </div>
	</main>
	
    <footer class="blog-footer">
      <p>We are using this template <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    
    <script src='//code.jquery.com/jquery-1.11.2.min.js'/>
	<script src='//code.jquery.com/jquery-migrate-1.2.1.min.js'/>
    <script src="../../../../assets/js/vendor/holder.min.js"></script>
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
  </body>
</html>
