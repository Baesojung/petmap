package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class userInfoTO {
	private String user_email;
	private String user_nickname;
	private String user_password;
	private String user_gender;
	private String user_birth;
	private String user_cdate;
	private String user_grade;
}
