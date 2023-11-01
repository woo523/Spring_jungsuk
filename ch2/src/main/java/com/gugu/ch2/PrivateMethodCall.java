package com.gugu.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception{ // 클래스를 못찾으면 에러가 나기때문에 예외처리해줌
		
		// Hello hello = new Hello();
		// hello.main(); // main 메서드가 private면 호출 불가능
		
		// 왜 url 호출은 가능했을까?
		// Reflection API를 사용 - 클래스 정보를 얻고 다를 수 있는 강력한 기능 제공
		// java.lang.reflect 패키지를 제공
		
		Class helloClass = Class.forName("com.gugu.ch2.Hello");
		// Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다.
		// 클래스 객체는 클래스에 대한 정보를 전부 갖고 있기 때문에 모든 것을 다 할 수 있다.
		Hello hello = (Hello)helloClass.newInstance(); // Class객체가 가진 정보로 객체 생성, 반환타입이 Object라서 형변환 필요
		Method main = helloClass.getDeclaredMethod("main"); // main 메서드 정보를 가지고 옴
		main.setAccessible(true); // private인 main()을 호출가능하게
		main.invoke(hello); // hello.main() 호출
		
		// 스프링에서 reflection API를 많이 사용하기 때문에 url에서 호출이 가능한 것.
	}

}
