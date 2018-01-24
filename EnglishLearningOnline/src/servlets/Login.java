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
import models.Student;

/**
 * Servlet implementation class Login
 */
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
			/*StudentDao dao = new StudentDao();
			 try {
				List<Student> list =  dao.getAllStudentList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
*/
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			String sql = "SELECT s.* FROM db_englishlearningonline.tb_user s WHERE s.username = ?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_englishlearningonline", "root", "");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			HttpSession session = request.getSession(true);
			
			ResultSet rs = ps.executeQuery();
			int type = 0;
			while(rs.next()){
				 type  = rs.getInt("usertype");
				 session.setAttribute("userType", type );
				 String name = rs.getString("username");
				 session.setAttribute("userName", name );
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
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		doGet(request, response);
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
