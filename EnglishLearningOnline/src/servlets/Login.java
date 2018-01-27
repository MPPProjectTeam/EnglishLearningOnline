package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.StudentDao;
import jdbc.DbUtil;
import models.Student;

/**
 * Servlet implementation class Login
 */
@SuppressWarnings("unused")
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		try {

			String email = request.getParameter("email");
			@SuppressWarnings("unused")
			String pass = request.getParameter("password");
			String sql = "SELECT s.* FROM db_englishlearningonline.tb_user s WHERE s.username = ?";
			Connection conn = DbUtil.getConnectionJama();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			int type = 0;
			while(rs.next()){
				 type  = rs.getInt("usertype");
				 HttpSession session = request.getSession(true);
				 session.setAttribute("userType", type );
				 String name = rs.getString("username");
				 session.setAttribute("userName", name );
				 int id = rs.getInt("userid");
				 session.setAttribute("userId", id );
				 
		      }
			if(type == 200000)
			{
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeProfessor.jsp");
				RequetsDispatcherObj.forward(request, response);	
			}
			else if (type == 100000)
			{
				RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeStudent.jsp");
				RequetsDispatcherObj.forward(request, response);
			}
			else
			{
				PrintWriter out = response.getWriter();
				out.println("no user name found");	
			}
		} //		doGet(request, response);
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
