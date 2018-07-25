package com.tarena.web.servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.domain.Book;
import com.tarena.service.BookServiceImpl;

public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        //调用业务逻辑
        BookServiceImpl bsi = new BookServiceImpl();
        List<Book> list = bsi.findAllBooks();
        //进行页面跳转
        if (list != null) {
            request.setAttribute("books", list);
            //把list放到request中
            request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }


}
