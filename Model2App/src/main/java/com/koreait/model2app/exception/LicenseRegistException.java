package com.koreait.model2app.exception;


//sun에서 제공해준 예외만으로 모든 경우의 수의 상세하고 디테일한 예외를 처리할 수없는 경우
//개발자만의 예외를 커스터마이징 할 수 있다..이때의 예외는 언어에서 강요하지 않는 Runtime예외를 상속받아
//처리한다..
public class LicenseRegistException extends RuntimeException{
	
	public LicenseRegistException(String message) {
		super(message);
	}
	
	//Throwable 은 예외 api의 최상위 인터페이스
	public LicenseRegistException(String message, Throwable e) {
		super(message, e);
	}
	
	/*
	public static void main(String[] args) {
		//자바의 예외는 처리를 강요하는 예외(SQLException ) , 강요하지 않는 예외(ArrayIndexOutofException..)
		int[] arr = new int[3];
		try {
			arr[0]=1;
			arr[1]=55;
			arr[2]=67;
			arr[3]=88;
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열을 넘엇어. 공부좀 더해");
		}
		
	}
	*/
}













