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
		Connection conn = DbUtil.getConnectionJama();
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
}
