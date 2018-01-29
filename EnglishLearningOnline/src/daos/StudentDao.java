package daos;

import  models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;



import jdbc.DbUtil;

public class StudentDao {
	
	public List<Student> getAllStudentList() throws SQLException{

		String sql = "select * from tb_user where usertype = 20002";	
		ResultSet rs=DbUtil.executQuery(sql, null);		
		List<Student> studentlist=new ArrayList<Student>();
		Student student = null;
		while(rs.next()){
			student=new Student();
			student.setUserid(rs.getInt("userid"));
			student.setUsername(rs.getString("username"));
			student.setUsertype(rs.getInt("usertype"));
			student.setEmailaddress(rs.getString("emailaddress"));
			studentlist.add(student);
		}
		return studentlist;
	}
	
	public void getStudentInfo(Student student) {

	    String sql= "select * from tb_user where usertype = 20002 and userid =" + student.getUserid();
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("select student success");
	    }else {
	    		System.out.println("select student failed");
	    }
	}
	
	public void addStudent(Student student) {

	    String sql= "insert into tb_user"+
	    		 "(userid,username,usertype,emailaddress)"+
	    	 	 "values("+student.getUserid()+","+ student.getUsername()+","+student.getUsertype()+
	    	 	 ","+student.getEmailaddress()+ ")";
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add student success");
	    }else {
	    		System.out.println("add student failed");
	    }
	}
	
	public void updateStudent(Student student) {

	    String sql= "update tb_user"+
	    "set userid="+student.getUsername()+",username="+student.getUsername()+",usertype="
	    		+student.getUsertype()+",emailaddress="+student.getEmailaddress();
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add student success");
	    }else {
	    		System.out.println("add student failed");
	    }
	    
	}
	
	public void deleteStudent(Student student) {
	    String sql= "delete from tb_user  where userid =" + student.getUserid();
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add student success");
	    }else {
	    		System.out.println("add student failed");
	    }
	}
	
	public static void enrollCourse(String studentId, String courseId) {
		String sql = "INSERT INTO db_englishlearningonline.tb_section (userid, courseid) VALUES( '"+studentId+
				"', '"+ courseId+"')";

		Connection conn = DbUtil.getConnection();
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getStudentIdByName(String userName) {
		String sql = "SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"+userName+"' LIMIT 1";
		Connection conn = DbUtil.getConnection();
		int retId =0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				retId = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retId;
		
	}
	
}