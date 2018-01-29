package daos;
import  models.Course;
//import models.Feedback;
//import models.Material;
import  models.Student;
import jdbc.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import net.sf.json.JSONArray;

public class CourseDao {
	
	public List<Course> getAllCourseList(Student student) throws SQLException{

		String sql = "select * from tb_course where userid ="+ student.getUserid();
		ResultSet rs= DbUtil.executQuery(sql, null);		
		List<Course> courselist=new ArrayList<Course>();
		Course course = null;
		while(rs.next()){
			course=new Course();
			course.setCourseid(rs.getInt("courseid"));
			course.setCoursename(rs.getString("coursename"));
			course.setProfessorid(rs.getInt("professorid"));
			course.setProfessorname(rs.getString("professorname"));
			course.setCreateTime(rs.getDate("createtime"));

			courselist.add(course);
		}

		return courselist;
	}
	

	public List<Course> getAvCourseList() throws SQLException{

		String sql = "select * from tb_course ";
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Course> courselist=new ArrayList<Course>();
		Course course = null;
		while(rs.next()){
			course=new Course();
			course.setCourseid(rs.getInt("courseid"));
			course.setCoursename(rs.getString("coursename"));
			course.setProfessorid(rs.getInt("professorid"));
			course.setProfessorname(rs.getString("professorname"));
			course.setCreateTime(rs.getDate("createdtime"));
			courselist.add(course);
		}

		return courselist;
	}
	public List<Course> getAvCourseListByProfName(String userId) throws SQLException{

		String sql = "select * from tb_course where professorid = "+userId;
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Course> courselist=new ArrayList<Course>();
		Course course = null;
		while(rs.next()){
			course=new Course();
			course.setCourseid(rs.getInt("courseid"));
			course.setCoursename(rs.getString("coursename"));
			course.setProfessorid(rs.getInt("professorid"));
			course.setProfessorname(rs.getString("professorname"));
			course.setCreateTime(rs.getDate("createdtime"));
			courselist.add(course);
		}

		return courselist;
	}
	
	public Course getCourseInfo(String courseid) throws SQLException {

	    String sql= "select * from tb_course where  courseid =" + courseid;
	    ResultSet rs=DbUtil.executQuery(sql, null);		
		Course course = null;
		while(rs.next()){
			course=new Course();
			course.setCourseid(rs.getInt("courseid"));
			course.setCoursename(rs.getString("coursename"));
			course.setProfessorid(rs.getInt("professorid"));
			course.setProfessorname(rs.getString("professorname"));
			course.setCreateTime(rs.getDate("createtime"));
		}
		return course;
	}
	
	
	public void addCourse(Course course) {

		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    String sql= "insert into tb_course"+
	    		 "(courseid,coursename,professorid,professorname,createtime)"+
	    	 	 "values("+course.getCourseid()+","+ course.getCoursename()+","+course.getProfessorid()+
	    	 	 ","+course.getProfessorname()+"," + df.format(day) + ")";
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("add course success");
	    }else {
	    		System.out.println("add course failed");
	    }
	}
	
	public void updateCourse(Course course) {

	    String sql= "update tb_course"+
	    "set courseid="+course.getCourseid()+",coursename="+course.getCoursename()+",professorname="
	    		+course.getProfessorname()+",professorid="+course.getProfessorid();
	   
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("update course success");
	    }else {
	    		System.out.println("update course failed");
	    }
	    
	}
	
	public void deleteCourse(String courseid) {
	    String sql= "delete from tb_course  where courseid =" + courseid;
	    int result = DbUtil.executUpdate(sql, null);
	    if (result ==0) {
	    		System.out.println("delete course success");
	    }else {
	    		System.out.println("delete course failed");
	    }
	}
}
