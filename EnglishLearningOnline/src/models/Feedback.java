package models;

import java.util.Date;

public class Feedback {
	
	private Integer feedbackid;
	private Integer usertype;
	private String comment;
	private Integer userid;
	private Date createTime;
	
	public Feedback() {
		
	}
	
	public void setFeedbackid(Integer feedbackid){
		 this.feedbackid = feedbackid;
	}
	public Integer getFeedbackid(){
		return this.feedbackid;
	}
	
	public void setUsertype(Integer usertype){
		 this.usertype = usertype;
	}
	public Integer getUsertype(){
		return this.usertype;
	}
	
	public void setComment(String comment){
		 this.comment = comment;
	}
	public String getComment(){
		return this.comment;
	}
	
	public void setUserid(Integer userid){
		 this.userid = userid;
	}
	public Integer getUserid(){
		return this.userid;
	}
	
	public void setCreateTime(Date createTime){
		 this.createTime = createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
}
