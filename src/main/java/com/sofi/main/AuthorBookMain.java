package com.sofi.main;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import com.sofi.dao.AuthorBookDAO;
import com.sofi.pojo.Author;
import com.sofi.pojo.Book;

public class AuthorBookMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		Author author = new Author();
		
		
		System.out.println("Enter the author id: ");
		author.setAuthorid(sc.nextInt());
		
		System.out.println("Enter the author name: ");
		author.setAuthorname(sc.next());
		
		System.out.println("Enter the author email: ");
		author.setAuthoremail(sc.next());
		
		
		Book book = new Book();
		
		System.out.println("Enter the book id: ");
		book.setBookid(sc.nextInt());
		
		System.out.println("Enter the book name: ");
		book.setBookname(sc.next());
		
		System.out.println("Enter the book email: ");
		book.setAuthor(author);
		
		AuthorBookDAO dao = new AuthorBookDAO();
		dao.addbookInfo(book, author);

	}

}
