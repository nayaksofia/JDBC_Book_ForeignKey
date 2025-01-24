package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sofi.dbUtil.DbUtil;
import com.sofi.pojo.Author;
import com.sofi.pojo.Book;

public class AuthorBookDAO {
    
	
	//1. Add book information 
	public void addbookInfo(Book book, Author author) throws ClassNotFoundException, SQLException {
		
		
		//Establish Connection With Database
		Connection con = DbUtil.getDbConn();
		
		//Check Connection 
		if(con != null) {
			System.out.println("dB Connection Established");
		}else {
			System.out.println("dB Connection Failed!!");
		}
		
		String sql = "insert into author values(?,?,?) ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,author.getAuthorid());
		ps.setString(2, author.getAuthorname());
		ps.setString(3, author.getAuthoremail());
		
		int rowInsert = ps.executeUpdate();
		if(rowInsert > 0) {
			System.out.println("Author record inserted!!!");
		}else {
			System.out.println("Author record failed.... ");
		}
		
		ps.close();
		
		String sqlb = "insert into book value(?,?,?)";
		PreparedStatement psb = con.prepareStatement(sqlb);
		
		psb.setInt(1, book.getBookid());
		psb.setString(2,book.getBookname());
		psb.setInt(3, book.getAuthor().getAuthorid());
		
		int rowBookInsert = psb.executeUpdate();
		if(rowBookInsert>0) {
			System.out.println("Book record inserted!!!");
		}else {
			System.out.println("Book record failed.....");
		}
		psb.close();
	}
}
