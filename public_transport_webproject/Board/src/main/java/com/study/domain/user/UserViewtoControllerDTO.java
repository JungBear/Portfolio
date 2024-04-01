package com.study.domain.user;


import lombok.Data;

@Data
public class UserViewtoControllerDTO {
	//user 
	private int userNo;
	private String id;          //PK  
    private String userName;	//이름
    private String nickname;	//닉네임
    private String email;	//이메일
    private String pwd;	//비밀번호
    private String pwdHint;	//비밀번호 힌트 질문
    private String pwdHintAns;	//비밀번호 힌트에 대한 답
    private int gender;	//성별
    private String age;	//나이
        
}
