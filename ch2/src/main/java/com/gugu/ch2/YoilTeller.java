package com.gugu.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		int yyyy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		
		// 2. 작업
		Calendar cal = Calendar.getInstance();
		cal.set(yyyy, mm-1, dd);
		
		int dayOfweek = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일~7:토
		char yoil = "일월화수목금토".charAt(dayOfweek-1);
		
		// 3. 출력
		response.setContentType("text/html"); /// 출력 타입
		response.setCharacterEncoding("utf-8"); // 인코딩
		PrintWriter out = response.getWriter(); // response객체에서 브라우저로의 출력 스트림을 얻는다, 예외 발생
		out.println(year +"년" + month + "월" + day + "일은 ");
		out.println(yoil + "요일입니다.");
		
	}
}
