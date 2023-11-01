package com.gugu.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	
	int iv = 10; // 인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. URL과 메서드를 연결
	@RequestMapping("/hello")
	private void main() { 
		System.out.println("Hello");
		System.out.println(cv); // OK
		System.out.println(iv); // OK
	} // 인스턴스 메서드가 더 유용
	
	public static void main2() { // static 메서드 - cv만 사용가능
		System.out.println(cv); // OK
//		System.out.println(iv); // 에러남
	}
}


//private로 바꿔도 호출 됨.  맵핑 되어있다는 것은 외부에서 호출 가능하게 하겠단 얘기 접근 제어자 상관없음.