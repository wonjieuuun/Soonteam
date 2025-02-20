package com.example.airport.controller;

import java.io.IOException;
import java.io.PrintWriter;


import com.example.airport.service.IMemberService;
import com.example.airport.service.MemberServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/member/idCheck.do")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
//		검사할 id 받기
		String memId = request.getParameter("mem_id");
		
//		서비스 객체 생성
		IMemberService service = MemberServiceImp.getInstance();
		
//		db에서 처리한 결과 받기
		int count = service.memberIdCount(memId);
		
		String jsonData = "";
		if(count > 0 ) {
			jsonData = "{\"result\" : \"이미 있는 아이디임 ㅇㅇ\"}";
		}else {
			jsonData = """
						{ 
						"result" : "사용가능"
						}
						""";
		}
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
