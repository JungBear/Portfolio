package com.study;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.user.UserMapper;
import com.study.domain.user.UserRequest;
import com.study.domain.user.UserResponse;

@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper usermapper;
	
	@Test
	void userSave() {
		UserRequest params = new UserRequest();
		params.setId("lysyeah6");
		params.setNickname("가나다라3");
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
		
		usermapper.addMember(params);
	}
	@Test
	void userSignin() {
		
		UserResponse params = new UserResponse();
		params.setId("lysyeah5");
		params.setPwd("123123qq");
		
	}
		
		
		
/*		#{name},
		#{nickname},
		#{email},
		#{pwd},
		#{pwd_hint},
		#{pwd_hint_ans},
		#{gender},
		#{age},
		#{sign_date},*/
}


