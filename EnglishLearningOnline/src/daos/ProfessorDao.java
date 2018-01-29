package daos;

import  models.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DbUtil;

public class ProfessorDao {
	
//	public List<Professor> getAllProfessorList() throws SQLException{
//
//		String sql = "select * from tb_user where usertype = 20001";	
//		ResultSet rs=DbUtil.executQuery(sql, null);		
//		List<Professor> professorlist=new ArrayList<Professor>();
//		Professor professor = null;
//		while(rs.next()){
//			professor=new Professor();
//			professor.setUserid(rs.getInt("userid"));
//			professor.setUsername(rs.getString("username"));
//			professor.setUsertype(rs.getInt("usertype"));
//			professor.setEmailaddress(rs.getString("emailaddress"));
//			professorlist.add(professor);
//		}
//		return professorlist;
//	}
	public List<Professor> getAllProfessorList() throws SQLException{

		String sql = "select * from db_englishlearningonline.tb_user where usertype = 200000";
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Professor> professorlist=new ArrayList<Professor>();
		Professor professor = null;
		while(rs.next()){
			professor=new Professor();
			professor.setUserid(rs.getInt("userid"));
			professor.setUsername(rs.getString("username"));
			professor.setUsertype(rs.getInt("usertype"));
			professor.setEmailaddress(rs.getString("emailaddress"));
			professorlist.add(professor);
		}
		return professorlist;
	}
	
	
	
	public void getProfessorInfo(Professor professor) {

	    String sql= "select * from tb_user where usertype = 20001 and userid =" + professor.getUserid();
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("select professor success");
	    }else {
	    		System.out.println("select professor failed");
	    }
	}
	
	public void addStudent(Professor professor) {

	    String sql= "insert into tb_user"+
	    		 "(userid,username,usertype,emailaddress)"+
	    	 	 "values("+professor.getUserid()+","+ professor.getUsername()+",20001"+
	    	 	  professor.getEmailaddress()+ ")";
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add student success");
	    }else {
	    		System.out.println("add student failed");
	    }
	}
	
	public void updateStudent(Professor professor) {

	    String sql= "update tb_user"+
	    "set userid="+professor.getUsername()+",username="+professor.getUsername()+",usertype="
	    		+professor.getUsertype()+",emailaddress="+professor.getEmailaddress();
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add professor success");
	    }else {
	    		System.out.println("add professor failed");
	    }
	    
	}
	
	public void deleteStudent(Professor professor) {
	    String sql= "delete from tb_user  where userid =" + professor.getUserid();
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add professor success");
	    }else {
	    		System.out.println("add professor failed");
	    }
	}
	public static void createCourse(String courseName, String profID, String profName, String PreCourseID) {
		String sql = "";
		if(PreCourseID == null || PreCourseID.equals(""))
		{
			sql = "INSERT INTO db_englishlearningonline.tb_course (coursename, professorid, professorname) " + 
					"  VALUES( '"+courseName+"', "+profID+", '"+profName+"') ";	
		}
		else
		{
			sql = "INSERT INTO db_englishlearningonline.tb_course (coursename, professorid, professorname, prerequisiteCourseId) " + 
					"  VALUES( '"+courseName+"', "+profID+", '"+profName+"', "+PreCourseID+") ";
		}
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