package com.study;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.main.BridgeDTO;
import com.study.domain.main.MainService;
import com.study.domain.post.PostResponse;

@SpringBootTest
public class MainServiceTest {
	
	@Autowired
	MainService MainService;
	
	@Test
	void getcongestionRate() {
		BridgeDTO params = new BridgeDTO();
		System.out.println("테스트호출");
		params.setName("성산대교");
		params.setStartPosition("성산대교남단");
		Date d = Date.valueOf("2022-11-16");
		params.setDate(d);
		Time T = Time.valueOf("12:00:00");
		params.setTime(T);
		List<BridgeDTO> result = MainService.getcongestionRate(params);
		System.out.println("결과 :"+result);
	}
}
