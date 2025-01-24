package com.sofi.pojo;

public class Author {

	private int authorid;
	private String authorname;
	private String authoremail;
	
	
	//Generate Setter and Getter
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getAuthoremail() {
		return authoremail;
	}
	public void setAuthoremail(String authoremail) {
		this.authoremail = authoremail;
	}
	
	//Generate toString Method
	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorname=" + authorname + ", authoremail=" + authoremail + "]";
	}
	
	
	
	
	
	
	
}
