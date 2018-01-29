package daos;
import  models.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jdbc.DbUtil;

public class FeedbakDao {
	
	public static ResultSet GetAllFeedByProfName (String profName) throws SQLException {
		String sql = "SELECT L.*, c.coursename FROM " + "(SELECT * FROM db_englishlearningonline.tb_feedback f "
	 			+ "WHERE f.userid = (SELECT s.userid FROM db_englishlearningonline.tb_user s WHERE s.username = '"
	 			+ profName + "' LIMIT 1) " + "UNION ALL " + "SELECT * FROM db_englishlearningonline.tb_feedback f "
	 			+ "WHERE f.courseid IN (select c.courseid FROM db_englishlearningonline.tb_course c WHERE c.professorname = '"
	 			+ profName + "' ) "
	 			+ ") L, db_englishlearningonline.tb_course c WHERE c.courseid = L.courseid ORDER BY L.createdtime DESC";
	 	Connection conn = DbUtil.getConnection();
	 	PreparedStatement ps = conn.prepareStatement(sql);
	 	ResultSet rs = ps.executeQuery();
	 	return rs;
	}
	
	public static void AddFeedbackByStudent(String userId, String userName, String courseId, String comment) {
		String sql ="INSERT INTO db_englishlearningonline.tb_feedback (userid, usertype, username, content, courseid) "+
		  "VALUES( "+userId+", 100000, '"+userName+"', '"+comment+"', "+courseId+" )";
		Connection conn = DbUtil.getConnectionJama();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ReplyFeedbackByProfessor(String userId, String userName, String courseId, String comment, String replyId) {
		String sql ="INSERT INTO db_englishlearningonline.tb_feedback (userid, usertype, username, content, courseid, replyfeedbackid) "+
		  "VALUES( "+userId+", 200000, '"+userName+"', '"+comment+"', "+courseId+" , "+replyId+" )";
		Connection conn = DbUtil.getConnectionJama();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Feedback> getFeedbackList(){
			return null;	
	}
}

