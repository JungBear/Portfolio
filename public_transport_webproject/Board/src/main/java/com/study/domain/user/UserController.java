package com.study.domain.user;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.common.dto.MessageDto;

import lombok.RequiredArgsConstructor;
// view -> Controller -> service -> mapper -> xml -> mapper -> service -> controller -> view // 화살표마다 DTO 실행
// view = .html, / .jsp / .php
@Controller
//위에 뜻 = 컨트롤러일 때만.
@RequiredArgsConstructor
public class UserController {
	
	public final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	
	//회원가입 페이지
	@GetMapping("/user/signup.do")
	public String signup() {
		return "user/signup";
	}
	
	// 아이디중복검사
    @PostMapping("/getId")
    @ResponseBody
    public String getId(UserRequest params) {
        logger.info("UserController getId()");
        boolean b = userService.getId(params);
        if(b) {
            return "no";
        }
        return "ok";
    }
    
	// 닉네임중복검사
    @PostMapping("/getNickname")
    @ResponseBody
    public String getNickname(UserRequest params) {
        logger.info("UserController getId()");
        boolean b = userService.getNickname(params);
        if(b) {
            return "no";
        }
        return "ok";
    }
	
    // 회원가입
    @PostMapping("/user/signup.do")
    public String addMember(UserViewtoControllerDTO params, Model model) {
    	UserRequest userrequest = new UserRequest();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(params.getAge(), formatter);
    	BeanUtils.copyProperties(params, userrequest,"age");
    	userrequest.setAge(dateTime);  	
    	 boolean b = false;
    	try {
    		b = userService.addMember(userrequest);
		} catch (Exception e) {
			b= false;
		}
        if(b) {
        	 MessageDto message = new MessageDto("회원가입이 완료되었습니다.", "/user/signin.do", RequestMethod.GET, null);
            	return showMessageAndRedirect(message, model);
        }else {
        	MessageDto message = new MessageDto("회원가입이 실패하였습니다. 중복검사를 실시해 주세요.", "/user/signup.do", RequestMethod.GET, null);
          	 return showMessageAndRedirect(message, model);
        }
        
        
    }
    
	//로그인 페이지
	@GetMapping("/user/signin.do")
	public String signin() {
		return "user/signin";
	}
	
	@PostMapping("/user/signin.do")
	@ResponseBody
	public UserResponse login(UserResponse params, HttpSession session) throws Exception{
		params = userService.login(params);
		if(params != null) {
			session.setAttribute("userInfo", params);
		}
		return params;
	}
	
	//아이디,비밀번호찾기 페이지
	@GetMapping("/user/findidpwd.do")
	public String findidpwd() {
		return "user/findidpwd";
	}
	
	@PostMapping(value = "/findid")
	@ResponseBody
	public UserRequest findIdAction(@RequestBody final UserRequest params, Model model) {
		UserRequest id = userService.findId(params);
		model.addAttribute("id", id);
		return id;
	}
	
	//비밀번호 찾기 페이지
	@GetMapping("/user/findpwd.do")
	public String findpwd() {
		return "user/findpwd";
	}
	
	@PostMapping(value = "/findpwd")
	@ResponseBody
	public UserRequest findPwdAction(@RequestBody final UserRequest params, Model model) {
		UserRequest pwd = userService.findPwd(params);
		model.addAttribute("id", pwd);
		return pwd;
	}
	
	//마이페이지 
	@GetMapping("/user/UserMyPage.do")
	public String mypage(@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
		if(user == null) {
        	return "user/needLogin";
        }
		model.addAttribute("userInfo", user);
		return "user/UserMyPage";
	}
	
	// 마이페이지 비번검사
	@GetMapping("/user/UserMyPageChk.do")
	public String checkPwdpage(
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		if(user == null) {
        	return "user/needLogin";
        }
		model.addAttribute("userInfo", user);
		System.out.println("세선에 저장된 비밀번호 : "+user.getPwd());
		return "user/UserMyPageChk";
	}
	
	@PostMapping("/user/UserMyPageChk.do")
	public String checkPwdAction(final UserRequest params,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		model.addAttribute("userInfo", user);
		boolean b = userService.checkPwd(params);
		if (b) {
			return "user/UserMyPage";
		}else {
			MessageDto message = new MessageDto("비밀번호가 올바르지 않습니다.", "/user/UserMyPageChk.do", RequestMethod.GET, null);
			return showMessageAndRedirect(message,model);
		}
     	
	}
	
    // 회원탈퇴
    @PostMapping("/user/secession.do")
    public String deletePost(@RequestParam final int userNo
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user,HttpServletRequest request, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	userService.deleteUser(userNo);
    	MessageDto message = new MessageDto("탈퇴가 완료되었습니다.", "/", RequestMethod.GET, null);
    	HttpSession session = request.getSession();
        session.invalidate();
    	
    	return showMessageAndRedirect(message,model);
    }
    
    //회원정보 수정페이지
    @GetMapping("/user/modify.do")
    public String modifyUser(@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	System.out.println("user : "+user);
    	Date date = java.sql.Date.valueOf(user.getAge());
    	System.out.println(date);
    	model.addAttribute("userInfo", user);
    	model.addAttribute("date", date);
        return "user/userMypageModify";
    }
    
    // 회원 정보 수정
    @PostMapping("/user/modify.do")
    public String modifyUserAction(final UserRequest params
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user,HttpServletRequest request
    		,HttpSession session, Model model) {
//    	System.out.println("컨트롤러 시작");
    	if(user == null) {
        	return "user/needLogin";
        }
//    	System.out.println("user : "+ user);
        userService.modifyUser(params);
        UserResponse user2 = new UserResponse();
        // user의 값들을 user2로 복사해라("pwdHint", "pwdHintAns", "email" 빼고)
        BeanUtils.copyProperties(user, user2, "pwdHint", "pwdHintAns", "email");
//        System.out.println(user2);
        user2.setPwdHint(params.getPwdHint());
        user2.setPwdHintAns(params.getPwdHintAns());
        user2.setEmail(params.getEmail());

        HttpSession session2 = request.getSession();
        //세션 제거
        session2.removeAttribute("userInfo");
        //세션 선언
        session.setAttribute("userInfo", user2);
        
        MessageDto message = new MessageDto("내 정보 수정이 완료되었습니다.", "/user/UserMyPage.do", RequestMethod.GET, null);
//        System.out.println("컨트롤러 끝");
        return showMessageAndRedirect(message, model);
    }
	
    //비밀번호 변경페이지
    @GetMapping("/user/changepwd.do")
    public String changePwd(@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	model.addAttribute("userInfo", user);
        return "user/UserChangePwd";
    }
    
    
    @PostMapping("user/changepwd.do")
    public String changePwdAction(final UserRequest params,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user,
    		HttpServletRequest request, HttpSession session, Model model) {
    	System.out.println("params :"+params);
    	
    	userService.changePwd(params);
    	UserResponse user2 = new UserResponse();
    	BeanUtils.copyProperties(user, user2, "pwd");
    	user2.setPwd(params.getPwd());
        HttpSession session2 = request.getSession();
        //세션 제거
        session2.removeAttribute("userInfo");
        //세션 선언
        session.setAttribute("userInfo", user2);
        System.out.println(session.getAttribute("userInfo"));
        
        MessageDto message = new MessageDto("비밀번호 변경이 완료되었습니다.", "/user/UserMyPage.do", RequestMethod.GET, null);
//      System.out.println("컨트롤러 끝");
      return showMessageAndRedirect(message, model);
    }	
    
    /*  로그아웃 */
    @GetMapping("/logout.do")
    public String logoutMainGET(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";        
    }
    
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
	
}