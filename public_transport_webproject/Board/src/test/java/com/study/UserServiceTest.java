package com.study;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.user.UserRequest;
import com.study.domain.user.UserService;
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService UserService;
	
	@Test
	void userSave() {
		UserRequest params = new UserRequest();
		params.setId("lysyeah62");
		params.setNickname("가나다라33");
		String str = "1992-05-05";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.KOREA);
		LocalDate date = LocalDate.parse(str, formatter);
		params.setAge(date);
		params.setEmail("d@c.com");
		params.setGender(0);
		params.setUserName("이용수");
		params.setPwd("123123qq");
		params.setPwdHint("자신의 보물 1호는?");
		params.setPwdHintAns("간다라마");
		
		UserService.addMember(params);
	}
}
