package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	private Integer courseid;
	private String coursename;
	private Integer professorid;
	private String professorname;
	private Date createTime;
	
	private List<Material> materials;
	private List<Feedback> feedbacks;
	
	public Course(){
		materials = new ArrayList<Material>();
		feedbacks = new ArrayList<Feedback>();
	}
	
	public void setCourseid(Integer courseid){
		 this.courseid = courseid;
	}
	public Integer getCourseid(){
		return this.courseid;
	}
	
	public void setCoursename(String coursename){
		 this.coursename = coursename;
	}
	public String getCoursename(){
		return this.coursename;
	}
	
	public void setProfessorid(Integer professorid){
		 this.professorid = professorid;
	}
	public Integer getProfessorid(){
		return this.professorid;
	}
	
	public void setProfessorname(String professorname){
		 this.professorname = professorname;
	}
	public String getProfessorname(){
		return this.professorname;
	}
	
	public void setCreateTime(Date createTime){
		 this.createTime = createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setMaterials(List<Material> materials){
		 this.materials = materials;
	}
	public List<Material> getMaterials(){
		return this.materials;
	}
	
	public void setFeedbacks(List<Feedback> feedbacks){
		 this.feedbacks = feedbacks;
	}
	public List<Feedback> getFeedbacks(){
		return this.feedbacks;
	}
	
}
