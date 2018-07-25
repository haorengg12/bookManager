package com.tarena.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tarena.domain.Book;
import com.tarena.service.BookServiceImpl;
import com.tarena.util.UUIDUtil;

public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        //获取表单信息
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            //手动生成id
            // TODO: 2018-07-25 手动生成ID
            book.setId(UUIDUtil.getUUID());
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        //调用业务逻辑
        BookServiceImpl bs = new BookServiceImpl();
        bs.addBook(book);


        //分发转向
        request.getRequestDispatcher("/servlet/bookListServlet").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

}
