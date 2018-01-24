package models;

import java.util.Date;

public class Material {
	private Integer materialid;
	private Integer usertype;
	private Integer userid;
	private String comment;
	private Date createTime;
	

	public Material(){

	}
	
	public void setMaterialid(Integer materialid){
		 this.materialid = materialid;
	}
	public Integer getMaterialid(){
		return this.materialid;
	}
	
	public void setUsertype(Integer usertype){
		 this.usertype = usertype;
	}
	public Integer getUsertype(){
		return this.usertype;
	}
	
	public void setUserid(Integer userid){
		 this.userid = userid;
	}
	public Integer getUserid(){
		return this.userid;
	}
	

	
	public void setComment(String comment){
		 this.comment = comment;
	}
	public String getComment(){
		return this.comment;
	}
	
	public void setCreateTime(Date createTime){
		 this.createTime = createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
	
}
