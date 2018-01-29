package daos;

import  models.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DbUtil;

public class MaterialDao {
	
	public List<Material> getCourseList(){
		return null;	
	}
	public static List<Material> getAllMaterialsByCourse(String studentId, String courseId) throws SQLException{
		String sql = "SELECT * FROM  db_englishlearningonline.tb_material m " + 
				"WHERE m.courseid = "+courseId;
		Connection conn = DbUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Material> materials = new ArrayList<Material>();
		Material m = null;
		while(rs.next()){
			m=new Material();
			m.setMaterialid(""+rs.getInt("materialid"));
			m.setMaterialName(rs.getString("materialname"));
			m.setCourseid(""+rs.getInt("courseid"));
			m.setFiletype(rs.getString("filetype"));
			m.setFileurl(rs.getString("fileurl"));
			m.setUploadedtime(rs.getDate("uploadedtime"));
			materials.add(m);
		}
		return materials;
	}
	
	public static void UploadMaterialForCourse(String mname,String ftype,String furl,String courseid,String pid) {

//		String materialname = request.getParameter("materialname");
//		String filetype = request.getParameter("filetype");
//		String fileurl = request.getParameter("fileurl");
//		String courseid = request.getParameter("courseid");
//		String professorid = request.getParameter("professorid");
	    
		
		String sql ="INSERT INTO db_englishlearningonline.tb_material (courseid, materialname, filetype, fileurl) "+
		  "VALUES( "+mname+","+courseid+","+ftype+","+furl+");";
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
	
	
	
//	public static void ReplyFeedbackByProfessor(String userId, String userName, String courseId, String comment, String replyId) {
//		String sql ="INSERT INTO db_englishlearningonline.tb_feedback (userid, usertype, username, content, courseid, replyfeedbackid) "+
//		  "VALUES( "+userId+", 200000, '"+userName+"', '"+comment+"', "+courseId+" , "+replyId+" )";
//		Connection conn = DbUtil.getConnection();
//		PreparedStatement ps;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
