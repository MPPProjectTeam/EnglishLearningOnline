package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FeedbakDao;
import daos.StudentDao;

/**
 * Servlet implementation class HomeStudent
 */
@WebServlet("/HomeStudent")
public class HomeStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String formType = request.getParameter("formType");
		String userName = request.getParameter("userName");
		if(formType.equals("Enroll"))
		{
			String courseID = request.getParameter("courseId");
			int userId = StudentDao.getStudentIdByName(userName);
			StudentDao.enrollCourse(""+userId, courseID);	
		}
		else if(formType.equals("Feedback")) {
			String courseID = request.getParameter("CourseIDFeed");
			String comment = request.getParameter("comment");
			int userId = StudentDao.getStudentIdByName(userName);
			FeedbakDao.AddFeedbackByStudent(""+userId, userName, courseID,comment);
		}
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeStudent.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

}
