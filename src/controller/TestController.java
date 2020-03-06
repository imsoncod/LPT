package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TestDAO;
import model.TestDTO;

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
					
					int a = 0, b = 0, c = 0, d = 0, e = 0;
					for(int i = 1; i <= 20; i++) {
						switch(session.getAttribute("q"+i).toString()) {
							case "a":
								a++;
								break;
							case "b":
								b++;
								break;
							case "c":
								c++;
								break;
							case "d":
								d++;
								break;
							case "e":
								e++;
								break;	
						}
					}
					
					String result = "탑";
					int temp = a;
					if(temp < b) {
						temp = b;
						result = "정글";
					}
					if(temp < c) {
						temp = c;
						result = "미드";
					}
					if(temp < d) {
						temp = d;
						result = "원딜";
					}
					if(temp < e) {
						temp = e;
						result = "서포터";
					}
					
					TestDTO dto = new TestDTO();
					dto.setNickname(session.getAttribute("nickname").toString());
					dto.setAge(Integer.parseInt(session.getAttribute("age").toString()));
					dto.setResult(result);
					
					TestDAO dao = new TestDAO();
					dao.insertTest(dto);
					
					response.sendRedirect("result.html");
					break;	
			}
		}
		
	}
}