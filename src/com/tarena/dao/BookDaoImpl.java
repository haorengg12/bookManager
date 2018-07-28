package com.tarena.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tarena.util.C3P0Util;

import com.tarena.domain.Book;

public class BookDaoImpl {
    //查询书籍信息
    public List<Book> findAllBooks() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
    }

    //添加书籍信息
    public void addBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)", book.getId(), book.getName(), book.getPrice(),
                book.getPnum(), book.getCategory(), book.getDescription());
    }

    //查找书籍
    public Book findBookById(String id) throws SQLException {
        // TODO Auto-generated method stub
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select*from book where id=?", new BeanHandler<Book>(Book.class), id);
    }

    //修改书籍信息
    public void updateBook(Book book) throws SQLException {
        // TODO Auto-generated method stub
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
                book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(), book.getId());
    }

    //根据ID删除信息
    public void delBook(String id) throws SQLException {
        // TODO Auto-generated method stub
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from book where id = ?", id);
    }

    public void deleAllbooks(String[] ids) throws SQLException {
        QueryRunner q = new QueryRunner(C3P0Util.getDataSource());
        Object[][] par = new Object[ids.length][];
        for (int i = 0; i < par.length; i++) {
            par[i] = new Object[]{ids[i]};
            System.out.println(par[i]);
        }
        q.batch("delete from book where id = ?", par);
    }

    public List<Book> searchBooks(String id, String category, String minprice, String maxprice, String name) throws SQLException {
        QueryRunner q = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from book where 1=1";
        List list = new ArrayList();
        if (!"".equals(id.trim())) {
            sql += " and id like ?";
            list.add("%" + id.trim() + "%");
        }
        if (!"".equals(category.trim())) {
            sql += " and category = ?";
            list.add(category);
        }
        if (!"".equals(name.trim())) {
            sql += " and name like ?";
            list.add("%" + name + "%");
        }
        if (!"".equals(minprice.trim())) {
            sql += " and price > ?";
            list.add(minprice);
        }
        if (!"".equals(maxprice.trim())) {
            sql += " and price < ?";
            list.add(maxprice);
        }
        return q.query(sql, new BeanListHandler<Book>(Book.class), list.toArray());
    }
}

