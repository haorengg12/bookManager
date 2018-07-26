package com.tarena.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tarena.service.BookServiceImpl;

import com.tarena.domain.Book;

public class BookListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(request, response);
		//1.获取表单信息
		//2.调用业务逻辑
		response.setContentType("text/html;Charset=UTF-8");
		
		BookServiceImpl bsi = new BookServiceImpl();
		List<Book> list = bsi.findAllBooks();
		
		//3.跳转页面
		
		if(list != null){
			request.setAttribute("books",list);//把list放到request对象当中
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	
	
}
