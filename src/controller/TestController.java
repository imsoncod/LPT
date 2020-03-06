package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		//System.out.println("uri = " + uri);
		
		//uri를 명령어 부분만 잘라냄
		String command = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		
		if(command != null) {
			//세션이 없으면 생성, 있으면 가져옴
			HttpSession session = request.getSession(true);
			//명령 별로 Control분류
			switch(command.trim()) {
				case "index":
					String nickname = request.getParameter("nickname");
					String age = request.getParameter("age");
					
					session.setAttribute("nickname", nickname);
					session.setAttribute("age", age);
					
					response.sendRedirect("test1.html");
					break;
					
				case "test1":
					for(int i = 1; i <= 10; i++) {
						session.setAttribute("q"+i, request.getParameter("q"+i));
					}
					
					response.sendRedirect("test2.html");
					break;
					
				case "test2":
					for(int i = 11; i <= 20; i++) {
						session.setAttribute("q"+i, request.getParameter("q"+i));
					}
					
					
					response.sendRedirect("result.html");
					break;	
			}
		}
		
	}
}