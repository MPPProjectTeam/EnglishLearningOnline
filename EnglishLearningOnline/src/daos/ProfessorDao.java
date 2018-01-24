package daos;

import  models.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DbUtil;

public class ProfessorDao {
	
	public List<Professor> getAllProfessorList() throws SQLException{

		String sql = "select * from tb_user where usertype = 20001";	
		ResultSet rs=DbUtil.executQuery(sql, null);		
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
}