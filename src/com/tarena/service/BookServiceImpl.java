package com.tarena.service;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dao.BookDaoImpl;

import com.tarena.domain.Book;

public class BookServiceImpl {
	//
	//鍒涘缓涓�涓猟ao瀵硅薄
	private BookDaoImpl bookDao = new BookDaoImpl();
	public List<Book> findAllBooks(){
		try {
			return bookDao.findAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		//鍙栬繑鍥炲�硷紝娌″彇鍒拌繑鍥瀗ull
	}
	
	//娣诲姞鍥句功
	public void addBook(Book book){
		try {
			bookDao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Book findBookById(String id) {
		// TODO Auto-generated method stub
		try {
			return bookDao.findBookById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void delBook(String id) {
		// TODO Auto-generated method stub
		try {
			bookDao.delBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
