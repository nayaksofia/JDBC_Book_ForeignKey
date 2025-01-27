package com.sofi.pojo;

public class Book {

	private int bookid;
	private String bookname;
	private int authorId ;

	//way-2: Use Aggregation[In Foreign Key]--> Bring the details of another class
	//private Author author;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
//way-2:Aggregation
	
//	public Author getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
	
	
	
	
}
