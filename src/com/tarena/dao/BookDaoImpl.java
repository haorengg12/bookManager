package com.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tarena.util.C3P0Util;

import com.tarena.domain.Book;

public class BookDaoImpl {
	//查询书籍信息
	public List<Book> findAllBooks() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select*from book",new BeanListHandler<Book>(Book.class));
	}
	
	//添加书籍信息
	public void addBook(Book book) throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)",book.getId(),book.getName(),book.getPrice(),
				book.getPnum(),book.getCategory(),book.getDescription());
	}

	//查找书籍
	public Book findBookById(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select*from book where id=?", new BeanHandler<Book>(Book.class),id);
	}

	//修改书籍信息
	public void updateBook(Book book) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
	}

	//根据ID删除信息
	public void delBook(String id) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id=?",id);
	}
	
}
