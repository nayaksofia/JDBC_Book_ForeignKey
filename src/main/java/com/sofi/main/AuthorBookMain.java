package com.sofi.main;


import java.sql.SQLException;
import java.util.Scanner;

import com.sofi.dao.AuthorBookDAO;
import com.sofi.pojo.Author;
import com.sofi.pojo.Book;

public class AuthorBookMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		//Author
		Author author = new Author();
		
		System.out.println("Enter the author id: ");
		author.setAuthorid(sc.nextInt());
		
		System.out.println("Enter the author name: ");
		author.setAuthorname(sc.next());
		
		System.out.println("Enter the author email: ");
		author.setAuthoremail(sc.next());
		
		
		//Book
		Book book = new Book();
		
		System.out.println("Enter the book id: ");
		book.setBookid(sc.nextInt());
		
		System.out.println("Enter the book name: ");
		book.setBookname(sc.next());
		
		//Set authorId for the book object 
		book.setAuthorId(author.getAuthorid()); 
		
		//book.setAuthor(author); //assigned the object author [way-2]
		
		AuthorBookDAO dao = new AuthorBookDAO();
		dao.addbookInfo(book, author);

	}

}
