package com.koreait.meeting.domain;

import lombok.Data;

@Data
public class Payment {
	private int payment_id;
	private int profile_id;
	private String c_name;
	private String c_card; 
	private int c_num; 
	private String c_email; 
	private int month; 
	private int year; 
	private String c_owner; 
	private int c_ccc; 
	private String c_cardtype; 
	private String c_pull; 
	private String c_bank; 
	private String c_account; 
}
