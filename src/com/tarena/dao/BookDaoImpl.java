package com.tarena.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tarena.domain.Book;
import com.tarena.util.C3P0Util;

public class BookDaoImpl {
    //查询
    public List<Book> findAllBooks() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
        //查询所有图书
    }

    //添加图书的方法
    public void addBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)", book.getId(), book.getName(),
                book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription());
    }

    //修改图书信息
    public Book findBookById(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class), id);


    }
}