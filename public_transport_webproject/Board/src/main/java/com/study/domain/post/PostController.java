package com.study.domain.post;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;
import com.study.domain.goodbad.GoodbadDTO;
import com.study.domain.goodbad.GoodbadService;
import com.study.domain.user.UserResponse;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final GoodbadService goodbadservice;
    
    // 정보 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openInfoPostWrite(@RequestParam(value = "id", required = false) final Long id,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	if (id != null) {
            PostResponse post = postService.findById(id);
            model.addAttribute("post", post);
        }
    	model.addAttribute("userInfo", user);
        return "post/write";
    }
        
    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user, HttpSession session, Model model) {
//    	int writer = (int) session.getAttribute("no");
    	if(user == null) {
        	return "user/needLogin";
        }
    	params.setWriterNo(user.getUserNo());
        postService.savePost(params);
        if (params.getType() == 0) {
        	 MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	 MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	 return showMessageAndRedirect(message, model);
        }
    }
    
    // 자유 게시글 리스트 페이지
    @GetMapping("/post/freelist.do")
    public String openFreePostList(@ModelAttribute("params") final SearchDto params,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
    	PagingResponse<PostResponse> response = postService.findFreePost(params);
    	model.addAttribute("response", response);
    	model.addAttribute("userInfo", user);
        return "post/freelist";
    }
    
    // 정보 게시글 리스트 페이지
    @GetMapping("/post/infolist.do")
    public String openInfoPostList(@ModelAttribute("params") final SearchDto params,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
    	PagingResponse<PostResponse> response = postService.findInfoPost(params);
    	model.addAttribute("response", response);
    	model.addAttribute("userInfo", user);
        return "post/list";
    } 
    
    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
        PostResponse post = postService.findById(id);
        GoodbadDTO goodbad = new GoodbadDTO();
        int intId = id.intValue();
        goodbad.setBoardId(intId);
        goodbad.setUserNo(user.getUserNo());
        boolean goodresult = goodbadservice.checkGood(goodbad);
        boolean badresult = goodbadservice.checkbad(goodbad);
        System.out.println("goodresult : "+ goodresult);
        System.out.println("badresult : "+ badresult);
        model.addAttribute("badresult", badresult);
        model.addAttribute("goodresult", goodresult);
        model.addAttribute("post", post);
        model.addAttribute("userInfo",user);
        return "post/view";
    }
    
    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final PostRequest params
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	params.setWriterNo(user.getUserNo());
        postService.updatePost(params);
        
        if (params.getType() == 0) {
        	MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }
    }
    
    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id
    		,@SessionAttribute(name = "userInfo", required = false)UserResponse user, @RequestParam final int type, Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	postService.deletePost(id);
        if(type == 0) {
        	MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/infolist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }else {
        	MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/freelist.do", RequestMethod.GET, null);
        	return showMessageAndRedirect(message, model);
        }
    }
    
	//마이페이지 내 글 보기 
	@GetMapping("/user/UserListMyBoard.do")
	 public String userPostList(@ModelAttribute("params") final SearchDto params,
	    		@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
	    	if(user == null) {
	        	return "user/needLogin";
	        }
	    	params.setUserNo(user.getUserNo());
	    	PagingResponse<PostResponse> response = postService.UserPostList(params);
	    	model.addAttribute("response", response);
	    	model.addAttribute("userInfo", user);
	        return "user/listMyBoard";
	    }
    
	
    
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}