package models;

import java.sql.SQLException;
import java.util.List;

import daos.MaterialDao;
import daos.StudentDao;

public class Student extends User {
	@SuppressWarnings("static-access")
	public void enrollCourse(String courseId) {
		
		StudentDao s = new StudentDao();
		s.enrollCourse(""+this.getUserid(), courseId);
		
	}
	
	public void giveFeedback() {
		
	}
	
	public void downloadMaterical() {
		
	}
	public List<Material> getAllMaterialsByCourse(String studentId, String courseId) throws SQLException{
		return MaterialDao.getAllMaterialsByCourse(studentId, courseId);
	}
}
