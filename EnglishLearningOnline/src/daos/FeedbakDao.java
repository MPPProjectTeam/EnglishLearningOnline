package daos;
import  models.Feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbc.DbUtil;

public class FeedbakDao {
	
	public static void AddFeedbackByStudent(String userId, String userName, String courseId, String comment) {
		String sql ="INSERT INTO db_englishlearningonline.tb_feedback (userid, usertype, username, content, courseid) "+
		  "VALUES( "+userId+", 100000, '"+userName+"', '"+comment+"', "+courseId+" )";
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
	public static void ReplyFeedbackByProfessor(String userId, String userName, String courseId, String comment, String replyId) {
		String sql ="INSERT INTO db_englishlearningonline.tb_feedback (userid, usertype, username, content, courseid, replyfeedbackid) "+
		  "VALUES( "+userId+", 200000, '"+userName+"', '"+comment+"', "+courseId+" , "+replyId+" )";
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
	
	public List<Feedback> getFeedbackList(){
			return null;	
	}
}

