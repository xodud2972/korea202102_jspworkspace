package com.koreait.meeting.controller.profile;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.meeting.domain.ProFile;
import com.koreait.meeting.model.common.file.FileManager;
import com.koreait.meeting.model.service.profile.ProFileService;


//등록, 수정, 삭제, 이미지 파일 등록
@Controller
public class ProFileController {

	private static final Logger logger = LoggerFactory.getLogger(ProFileController.class);
	@Autowired
	private ProFileService proFileService;
	@Autowired
	private  FileManager fileManager;
	
//	//?? 모든 프로필 가져오기 ??
//	@RequestMapping(value="/regist", method=RequestMethod.GET)
//	public String getList(Model model, HttpServletRequest request){
//		//3단계 : 일시키기
//		List profileList = proFileService.selectAll();
//		
//		//4단계 : 결과저장
//		model.addAttribute("profileList",profileList);
//		
//		return "admin/profile/regist";
//	}
//	
	//프로필 등록폼 요청처리 
	@GetMapping("/registform")
	public String registForm(Model model, HttpServletRequest request) {
		//3단계: 최상위 카테고리 가져오기 
		List profileList = proFileService.selectAll();
		
		//4단계:결과저장 
		model.addAttribute("profileList", profileList);
		
		return "admin/profile/regist";
	}
	
	//프로필 등록 요청(파일업로드 포함)
	@PostMapping("/regist")
	public String regist(ProFile proFile, HttpServletRequest request) {
		
		MultipartFile photo=proFile.getPhoto();
		ServletContext context = request.getServletContext();
		long time=System.currentTimeMillis();
		
		String imgfile=time+"."+fileManager.getExt(photo.getOriginalFilename());
		fileManager.saveFile(context, imgfile , photo);
		proFile.setFilename(imgfile); 
		proFileService.regist(proFile);
		
		
		return "admin/main/index"; // 프로필 목록페이지를 재요청
	}

//	//프로필 상세보기 요청 , 상세보기 만들어야하나유......ㅜ
//	@GetMapping("/profile/detail")
//	public String getDetail(int profile_id, Model model, HttpServletRequest request) {
//		
//		//3단계: 일시키기
//		ProFile proFile= proFileService.select(profile_id);
//		List profileList=proFileService.selectAll();
//		
//		//4단계: 결과 저장
//		model.addAttribute("ProFile", proFile);
//		model.addAttribute("profileList", profileList);
//		
//		return "admin/main/index";
//	}
	
	//프로필 수정 처리하기
	@PostMapping("/update")
	public String update(ProFile proFile, HttpServletRequest request) {
		
		proFileService.update(proFile);
		
		return "redirect:/profile/regist"; // 다시 등록폼으로
	}

	
	//프로필 삭제 처리하기
	@PostMapping("/del")
	public String delete(int profile_id, HttpServletRequest request){
		//3단계
		proFileService.delete(profile_id);
		
		return "redirect:/profile/regist"; //리스트로 가기
	}


}
