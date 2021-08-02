package com.koreait.meeting.domain;

import org.springframework.web.multipart.MultipartFile;


import lombok.Data;

@Data
public class ProFile {
	private int profile_id;
	private int sign_id;
	private Admin admin; //부모정보를 has a 관계로 보유한다
	private String nickname;
	private String age;
	private String sex;
	private String height;
	private String introduce;
	private String weight;
	private String job;
	private String area;
	private String interest;
	private String mbti;
	MultipartFile photo;
	private String filename;
}
