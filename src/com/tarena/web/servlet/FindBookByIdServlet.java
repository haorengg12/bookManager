package com.tarena.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tarena.domain.Book;
import com.tarena.service.BookServiceImpl;

public class FindBookByIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  String id=request.getParameter("id");
	  //调用业务逻辑
	   BookServiceImpl bs=new BookServiceImpl();
	   Book book=bs.findBookById(id);//去创建方法
	   
	   request.setAttribute("book", book);
	   request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);
	   }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
