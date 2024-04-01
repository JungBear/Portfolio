package com.study.domain.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.domain.post.PostResponse;
import com.study.domain.user.UserResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final MainService MainService;

	@GetMapping(value = "/")
	public String main(@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		List<PostResponse> freePosts = MainService.summaryFreeList();
		List<PostResponse> infoPosts = MainService.summaryInfoList();
        model.addAttribute("freePosts", freePosts);
        model.addAttribute("infoPosts", infoPosts);
        model.addAttribute("userInfo", user);
		
		return "home";
	}

	@GetMapping(value = "/congestionrate")
	@ResponseBody
	public List<BridgeDTO> getcongestionRate(String selHour,String selDate,String name, Model model) {
		BridgeDTO bridgeDTO = new BridgeDTO();
		bridgeDTO.setDate(LocalDate.parse(selDate));
		bridgeDTO.setTime(LocalTime.parse(selHour+":00"));
		bridgeDTO.setName(name);
		System.out.println(bridgeDTO);
		List<BridgeDTO> bridgeList = MainService.getcongestionRate(bridgeDTO);
		model.addAttribute("bridgeList", bridgeList);
		System.out.println("bridgeList값 : "+bridgeList);
		System.out.println("bridgeList의 크기 : " + bridgeList.size());
		return bridgeList;
	}

}
