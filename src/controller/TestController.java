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
					session.setAttribute("a", a);
					session.setAttribute("b", b);
					session.setAttribute("c", c);
					session.setAttribute("d", d);
					session.setAttribute("e", e);
					
					String result = "탑";
					String message = "고독을 견딜 준비가 되셨나요?";
					int temp = a;
					if(temp >= 7) {
						message = "탑신병자가 되지 않도록 조심하세요!";
					}
					if(temp >= 10) {
						message = "정글 탓 작작 좀 하세요;";
					}
					
					if(temp < b) {
						temp = b;
						result = "정글";
						message = "어디든지 부르면 달려갈 준비가 되셨군요?";
						if(temp >= 7) {
							message = "오브젝트 좀 챙기세요^^";
						}
						if(temp >= 10) {
							message = "롤은 메이플이 아닙니다^^";
						}
					}
					if(temp < c) {
						temp = c;
						result = "미드";
						message = "야스오는 추천드리지 않습니다";
						if(temp >= 7) {
							message = "블루 안 준다고 던지시면 안 돼요~";
						}
						if(temp >= 10) {
							message = "당신이 세상의 중심이라고 생각하시면 안 됩니다";
						}
					}
					if(temp < d) {
						temp = d;
						result = "원딜";
						message = "서포터와 호흡을 맞춰 게임을 승리로 이끌어보세요!";
						if(temp >= 7) {
							message = "핑크와드 정도는 서포터한테 양보할 수 있지 않나요?";
						}
						if(temp >= 10) {
							message = "그만 좀 들이대세요";
						}
					}
					if(temp < e) {
						temp = e;
						result = "서포터";
						message = "사랑으로 원딜을 보살펴주세요!";
						if(temp >= 7) {
							message = "당신은 도구임을 잊지 마세요";
						}
						if(temp >= 10) {
							message = "cs 취식은 범죄에 해당합니다";
						}
					}
					session.setAttribute("result", result);
					session.setAttribute("message", message);
					
					TestDTO dto = new TestDTO();
					dto.setNickname(session.getAttribute("nickname").toString());
					dto.setAge(Integer.parseInt(session.getAttribute("age").toString()));
					dto.setResult(result);
					
					TestDAO dao = new TestDAO();
					dao.insertTest(dto);
					
					/*
					int[] array = dao.getTest();
					for(int i = 0; i < 5; i++) {
						session.setAttribute("graph"+i, array[i]);
					}
					*/
					
					response.sendRedirect("result.jsp");
					break;	
			}
		}
		
	}
}