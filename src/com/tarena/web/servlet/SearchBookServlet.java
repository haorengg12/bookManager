package com.tarena.web.servlet;

import com.tarena.domain.Book;
import com.tarena.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String category = request.getParameter("category");
        String name = request.getParameter("name");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");
        BookServiceImpl bs = new BookServiceImpl();
        List<Book> list = bs.searchBooks(id, category, name, maxprice, minprice);
        request.setAttribute("books", list);
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
    }
}
