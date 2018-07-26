package com.tarena.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tarena.service.BookServiceImpl;
import com.tarena.util.UUIDUtil;

import com.tarena.domain.Book;

public class AddBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		//获取表单信息
				Book book = new Book();
				try {
					BeanUtils.populate(book, request.getParameterMap());
					book.setId(UUIDUtil.getUUID());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//调用业务逻辑
				
				BookServiceImpl bs = new BookServiceImpl();
				bs.addBook(book);
				//分发专向
				
				request.getRequestDispatcher("/servlet/bookListServlet").forward(request,response);
			}

			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				super.doPost(req, resp);
			}

}
