package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FeedbakDao;
import daos.ProfessorDao;
import daos.StudentDao;

/**
 * Servlet implementation class HomeProfessor
 */
@WebServlet("/HomeProfessor")
public class HomeProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProfessor() {
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
		if(formType.equals("CreateCourse"))
		{
			String courseName = request.getParameter("courseName");
			String preCourseId = request.getParameter("preCourseId");
			int userId = ProfessorDao.getStudentIdByName(userName);
			//StudentDao.enrollCourse(""+userId, courseID);	
			ProfessorDao.createCourse(courseName, ""+userId, userName, preCourseId);
		}
		else if(formType.equals("Feedback")) {
			String courseID = request.getParameter("CourseIDFeed");
			String comment = request.getParameter("comment");
			String replyID = request.getParameter("ReplyId");
			int userId = StudentDao.getStudentIdByName(userName);
			FeedbakDao.ReplyFeedbackByProfessor(""+userId, userName, courseID,comment, replyID);
		}
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeProfessor.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

}
