package com.sofi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

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

	// 1. Add book information
	public void addbookInfo(Book book, Author author) throws ClassNotFoundException, SQLException {

		// Establish Connection With Database
		Connection con = DbUtil.getDbConn();

		// Check Connection
		if (con != null) {
			System.out.println("dB Connection Established");
		} else {
			System.out.println("dB Connection Failed!!");
		}

		// Insert Author
		String sqlAuthor = "insert into author values(?,?,?) ";
		PreparedStatement psAuthor = con.prepareStatement(sqlAuthor);

		psAuthor.setInt(1, author.getAuthorid());
		psAuthor.setString(2, author.getAuthorname());
		psAuthor.setString(3, author.getAuthoremail());

		int rowInsert = psAuthor.executeUpdate();
		if (rowInsert > 0) {
			System.out.println("Author record inserted!!!");
		} else {
			System.out.println("Author record failed.... ");
			return; // Stop further execution if author insertion fails
		}

		psAuthor.close();

		// Insert Book
		String sqlBook = "insert into book values(?,?,?)";
		PreparedStatement psBook = con.prepareStatement(sqlBook);

		psBook.setInt(1, book.getBookid());
		psBook.setString(2, book.getBookname());
		psBook.setInt(3, book.getAuthorId()); // Reference the already-inserted author

		// psb.setInt(3, book.getAuthor().getAuthorid()); //way-2: as aggregation

		int rowBookInsert = psBook.executeUpdate();

		if (rowBookInsert > 0) {
			System.out.println("Book record inserted!!!");
		} else {
			System.out.println("Book record insertion failed.....");
		}
		psBook.close();
		con.close();
	}

	// 2. View Book Information:retrieveAllBook
	public void retrieveAllBookRecords(Book book, Author author) throws ClassNotFoundException, SQLException {

		// Establish Connection With Database
		Connection con = DbUtil.getDbConn();

		// Check Connection Established or Not
		if (con != null) {
			System.out.println("dB Connection Established");
		} else {
			System.out.println("dB Connection Failed!!");
		}

		// View List of Authors
		String sqlAuthors = "select * from author";
		PreparedStatement psAuthor = con.prepareStatement(sqlAuthors);

		ResultSet rsAuthor = psAuthor.executeQuery();

		System.out.println("View All Autors List: ");
		System.out.println("======================================");
		while (rsAuthor.next()) {
			System.out.println(rsAuthor.getInt(1) + " " + rsAuthor.getString(2) + " " + rsAuthor.getString(3));
		}

		psAuthor.close();

		// View List of Books
		String sqlBooks = "select * from book";
		PreparedStatement psBook = con.prepareStatement(sqlBooks);

		ResultSet rsBook = psBook.executeQuery();
		System.out.println("--------------------------------------");
		System.out.println("View All Books List: ");
		System.out.println("=====================================");
		while (rsBook.next()) {
			System.out.println(rsBook.getInt(1) + " " + rsBook.getString(2) + " " + rsBook.getInt(3));
		}

		psBook.close();	
		con.close();
	}

	// 3 View Book Information By Author Email and Author Name :retrieveBookByAuthorEmailAndAuthorName
	public void retrieveBookByAuthorEmailAndAuthorName(Author author, Book book) throws ClassNotFoundException, SQLException {

		// Establish Connection With Database
		Connection con = DbUtil.getDbConn();

		// Check Connection Established or Not
		if (con != null) {
			System.out.println("dB Connection Established");
		} else {
			System.out.println("dB Connection Failed!!");
		}

		/*
		 * Because the book table does not contain the authoremail column. Instead, you
		 * should use the authorid as the foreign key to join the author and book tables
		 * and filter by authoremail.
		 * 
		 */

		// View book information By Author Email
		String sql = "SELECT b.bookid, b.bookname, b.authorid " +
                "FROM book b " +
                "JOIN author a ON b.authorid = a.authorid " +
                "WHERE a.authoremail = ?";

		    PreparedStatement ps = con.prepareStatement(sql);

			System.out.println("Enter the author email: ");
			Scanner sc = new Scanner(System.in);
			String authEmail = sc.next();
			ps.setString(1, authEmail);

			ResultSet rsBook = ps.executeQuery();
			System.out.println("Books by Author Email ( " + authEmail + " ): ");
			System.out.println("==============================");

			boolean found = false;
			while (rsBook.next()) {
				found = true;
				System.out.println(rsBook.getInt(1) + " " + rsBook.getString(2));
			}

			if (!found) {
				System.out.println("No books found for this author email.");
			}
			
		
		
			//--------------------------------------------------------------
			
			// view book information by author name
			String sqlName = "SELECT b.bookid, b.bookname, b.authorid " + "FROM book b "
					+ "JOIN author a ON b.authorid = a.authorid " + "WHERE a.authorname = ?";

			PreparedStatement psName = con.prepareStatement(sqlName );

			System.out.println("Enter the author name: ");
			Scanner scN = new Scanner(System.in);
			String authName = scN.nextLine();
			psName.setString(1, authName);

			// Execute Query
			ResultSet rsB = psName.executeQuery();
			System.out.println("Book By Author Name (" + authName + " ) :");
			System.out.println("=====================================================");
			boolean found1 = false;

			while (rsB.next()) {
				found1 = true;
				System.out.println(rsB.getInt(1) + " " + rsB.getString(2));
			}

			if (!found1) {
				System.out.println("No book found for this author name.");
			}
			
		
			psName.close();
			con.close();
	}
	

	//4. Retrieve Author Name And Author Email By Specific Book :retrieveAuthNameAndEmailByBookName 
	public void retrieveAuthNameAndEmailByBookName(Author author, Book book) {
		
	}

	// 5. Update the Record By Id:updateBookById

	// 6. Delete the record:deleteBook
}
