package com.tarena.service;

import java.sql.SQLException;
import java.util.List;

import com.tarena.dao.BookDaoImpl;
import com.tarena.domain.Book;

public class BookServiceImpl {
    //
    //创建一dao对象
    private BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> findAllBooks() {
        try {
            return bookDao.findAllBooks();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        //取返回值,没取到返回null
    }

    //添加图书
    public void addBook(Book book) {
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
}
