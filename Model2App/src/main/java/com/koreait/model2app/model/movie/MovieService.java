package com.koreait.model2app.model.movie;

//영화에 대한 조언을 판단하는 모델 객체(플랫폼에 중립적 따라서 웹,응용 모두 사용 가능==재사용성)
public class MovieService {
	public String getAdvice(String movie) {
		String msg=null;
		
		if(movie.equals("미션임파서블")) {
			msg="톰크루주의 최고 액션첩보 영화";
		}else if(movie.equals("크루엘라")) {
			 msg="디즈니의 명작";
		}else if(movie.equals("어벤저스")) {
			msg="마블의 히어로";
		}else if(movie.equals("어바웃타임")) {
			msg="감동의 멜로 드마라";
		}
		return msg;
	}
}
