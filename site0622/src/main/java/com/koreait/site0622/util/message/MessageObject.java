package com.koreait.site0622.util.message;

public class MessageObject {
	
	//메세지 출력 후 원하는 url 요청
	public String getMsgURL(String msg, String url) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("location.href='"+url+"';");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	//메세지 출력 후 뒤로 가기
	public String getmsgBack(String msg) {
		StringBuilder sb = new StringBuilder();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("history.back();");
		sb.append("</script>");
		
		return sb.toString();
	}
}
