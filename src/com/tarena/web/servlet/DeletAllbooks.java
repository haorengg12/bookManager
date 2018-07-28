package com.tarena.web.servlet;

import com.tarena.domain.Book;
import com.tarena.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletAllbooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("ids");
        BookServiceImpl bs = new BookServiceImpl();
        bs.deleAllbooks(ids);
        req.getRequestDispatcher("bookListServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
