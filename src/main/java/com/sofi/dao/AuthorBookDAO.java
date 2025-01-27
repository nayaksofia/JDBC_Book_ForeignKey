package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sofi.dbUtil.DbUtil;
import com.sofi.pojo.Author;
import com.sofi.pojo.Book;

/* Note: 
 * ------
 * insert, update, delete operation --> executeUpdate(); 
 * retrieve operation :: retrieve all (or) retrieveById--> executeQuery() 
 * and store in ResultSet.
 * 
 */

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
		
		//Insert Author
		String sqlAuthor = "insert into author values(?,?,?) ";
		PreparedStatement psAuthor = con.prepareStatement(sqlAuthor);
		
		psAuthor.setInt(1,author.getAuthorid());
		psAuthor.setString(2, author.getAuthorname());
		psAuthor.setString(3, author.getAuthoremail());
		
		int rowInsert = psAuthor.executeUpdate();
		if(rowInsert > 0) {
			System.out.println("Author record inserted!!!");
		}else {
			System.out.println("Author record failed.... ");
			return; //Stop further execution if author insertion fails 
		}
		
		psAuthor.close();
		
		
		//Insert Book
		String sqlBook = "insert into book values(?,?,?)";
		PreparedStatement psBook = con.prepareStatement(sqlBook);
		
		psBook.setInt(1, book.getBookid());
		psBook.setString(2,book.getBookname());
		psBook.setInt(3, book.getAuthorId() ); //Reference the already-inserted author
		
		//psb.setInt(3, book.getAuthor().getAuthorid()); //way-2: as aggregation
		
		int rowBookInsert = psBook.executeUpdate();
		
		if(rowBookInsert>0) {
			System.out.println("Book record inserted!!!");
		}else {
			System.out.println("Book record insertion failed.....");
		}
		psBook.close();
	}
	
	
	//2. View Book Information:retrieveAllBook 
	
	//3. View Book Information By Id:retrieveBookById
	
	//4. Update the Record By Id:updateBookById
	
	//5. Delete the record:deleteBook
}
