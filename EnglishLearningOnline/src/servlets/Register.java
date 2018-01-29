package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;

import jdbc.DbUtil;

/**
 * Servlet implementation class Register
 */
@SuppressWarnings("unused")
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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

			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			@SuppressWarnings("unused")
			String password = request.getParameter("password");
			String userType = request.getParameter("usertype");
			int type = userType.equals("s") ? 100000 : 200000;
			
			String sql = "INSERT INTO db_englishlearningonline.tb_user (username, usertype, emailaddress) VALUES( '"+userName+
					"', "+type+", '"+ email+"')";
			Connection conn = DbUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = null;
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
			    System.out.println("Auto Generated Primary Key " + rs.getInt(1)); 
			   } 
			else
				System.out.println("Obsoyo " );
			/*ps.setString(1, userName);
			ps.setInt(2, type);
			ps.setString(3, email);*/
			HttpSession session = request.getSession(true);
			ps.executeUpdate(sql);
			
			session.setAttribute("userType", type);
			session.setAttribute("userName", userName );
			
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
				out.println("couldnt create user");	
			}		
		} //		doGet(request, response);
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
