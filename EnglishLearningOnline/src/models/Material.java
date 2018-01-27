package models;

import java.util.Date;

public class Material {
	private String materialid;
	private String materialName;
	private String courseid;
	private String filetype;
	private String fileurl;
	private Date uploadedtime;
	

	public Material(){

	}


	public String getMaterialid() {
		return materialid;
	}


	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}


	public String getMaterialName() {
		return materialName;
	}


	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}


	public String getCourseid() {
		return courseid;
	}


	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}


	public String getFiletype() {
		return filetype;
	}


	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}


	public String getFileurl() {
		return fileurl;
	}


	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}


	public Date getUploadedtime() {
		return uploadedtime;
	}


	public void setUploadedtime(Date uploadedtime) {
		this.uploadedtime = uploadedtime;
	}
	

	
}
