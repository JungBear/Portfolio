package com.study.domain.goodbad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.domain.user.UserResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GoodbadController {
    private final GoodbadService goodbadservice;


	@PostMapping("/clickgood")
	@ResponseBody 
	public void likeup(//@RequestParam("boardId") int boardid, @RequestParam(value="userNo") int userno,
			@RequestBody GoodbadDTO params,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user) {
		System.out.println("컨트롤러 연결 성공");
		//GoodbadDTO params = new GoodbadDTO();
		//params.setBoardId(boardid);
		//params.setUserNo(userno);
		System.out.println(params);
		goodbadservice.clickGood(params);
		goodbadservice.increaseCountGood(params.getBoardId());
	}
	
	@ResponseBody
	@PostMapping("/cancelgood")
	public void likeDown(@RequestBody GoodbadDTO params, 
			@SessionAttribute(name = "userInfo", required = false)UserResponse user) {
		System.out.println("좋아요 싫어요!");
		goodbadservice.cancelGood(params);
		goodbadservice.decreaseCountGood(params.getBoardId());
	}
	
	@PostMapping("/clickbad")
	@ResponseBody 
	public void badUp(//@RequestParam("boardId") int boardid, @RequestParam(value="userNo") int userno,
			@RequestBody GoodbadDTO params,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user) {
		System.out.println("컨트롤러 연결 성공");
		//GoodbadDTO params = new GoodbadDTO();
		//params.setBoardId(boardid);
		//params.setUserNo(userno);
		System.out.println(params);
		goodbadservice.clickBad(params);
		goodbadservice.increaseCountBad(params.getBoardId());
	}
	
	@ResponseBody
	@PostMapping("/cancelbad")
	public void badDown(@RequestBody GoodbadDTO params, 
			@SessionAttribute(name = "userInfo", required = false)UserResponse user) {
		System.out.println("좋아요 싫어요!");
		goodbadservice.cancelGood(params);
		goodbadservice.decreaseCountBad(params.getBoardId());
	}
}
