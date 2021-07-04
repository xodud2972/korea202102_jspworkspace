package com.koreait.model2app.controller.movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.model2app.controller.Controller;
import com.koreait.model2app.model.movie.MovieService;

//영화에 대한 요청을 처리하는 하위 컨트롤러
//3단계: 알맞는 객체에 일시킨다, 4단계: 저장할 것이 있다면 결과저장(형님컨트롤러와 공유할 수있는 곳request, session)
public class MovieController implements Controller{
	MovieService service;
	
	public MovieController() {
		service = new MovieService();
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String movie=request.getParameter("movie");
		String msg=service.getAdvice(movie);//결과 반환 
		
		//4단계: 결과저장 
		request.setAttribute("msg", msg);
	}
	@Override
	public boolean isForward() {
		return true;
	}	
	public String getViewName() {
		return "/movie/result";
	}
	
}









