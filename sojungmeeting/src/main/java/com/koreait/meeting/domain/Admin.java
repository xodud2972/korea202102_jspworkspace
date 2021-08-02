package com.koreait.meeting.domain;

import lombok.Data;

@Data
public class Admin {
	
	private int sign_id;
	private String user;
	private String password;
	private String email;
}
