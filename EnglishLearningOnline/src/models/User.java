package models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Integer userid;
	private String username;
	private Integer usertype;
	private String emailaddress;
	private List<Course> courselist;
	public User(){
		courselist = new ArrayList<Course>();
	}
	
	public void setUserid(Integer userid){
		 this.userid = userid;
	}
	public Integer getUserid(){
		return this.userid;
	}
	
	public void setUsername(String username){
		 this.username = username;
	}
	public String getUsername(){
		return this.username;
	}
	
	public void setUsertype(Integer usertype){
		 this.usertype = usertype;
	}
	public Integer getUsertype(){
		return this.usertype;
	}
	
	public void setEmailaddress(String emailaddress){
		 this.emailaddress = emailaddress;
	}
	public String getEmailaddress(){
		return this.emailaddress;
	}
	
	public void setCourselist(List<Course> courselist){
		 this.courselist = courselist;
	}
	public List<Course> getCourselist(){
		return this.courselist;
	}
	
	public void register() {
		
	}
	
	public void login() {
		
	}
}
