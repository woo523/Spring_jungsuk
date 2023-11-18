package com.gugu.ch2;

public class Ex {

	static long startTime = 0;
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		ThreadEx1_2 t2 = new ThreadEx1_2();
				
		t1.start();
		t2.start();
		
		
		startTime = System.currentTimeMillis();
		
//		try {
//			t1.join(); // 쓰레드의 작업이 끝날때까지 기다린다
//			t2.join();
//		} catch (Exception e) {
//		}
		
		System.out.println("소요시간"+(System.currentTimeMillis()-startTime));
		
		
	}
		
}


class ThreadEx1_1 extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
	}
	
}


class ThreadEx1_2 extends Thread{
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.print("|");
		}
	}
	
}
