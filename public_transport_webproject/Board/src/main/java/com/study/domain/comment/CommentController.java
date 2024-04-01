package com.study.domain.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.common.dto.SearchDto;
import com.study.domain.user.UserResponse;
import com.study.paging.PagingResponse;


@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	// /comments - 댓글작성, /comments/{id} - 댓글수정
	@RequestMapping(value = { "/comments", "/comments/{id}" }, method = { RequestMethod.POST, RequestMethod.PATCH })
	@ResponseBody
	public CommentDTO registerComment(@PathVariable(value = "id", required = false) Integer id,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,
			@RequestBody final CommentDTO params,Model model) {
		System.out.println("registerComment 컨트롤러 인식됨");
		params.setWriterNo(user.getUserNo());
		System.out.println("보드타입"+params.getBoardType());
		try {
			if (id != null) {
				params.setId(id);
				
			}
			System.out.println("서비스 전");
			boolean isRegistered = commentService.registerComment(params);
			model.addAttribute("result", isRegistered);

		} catch (DataAccessException e) {
			model.addAttribute("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			model.addAttribute("message", "시스템에 문제가 발생하였습니다.");
		}
		model.addAttribute("userInfo", user);
		model.addAttribute("CDTO",params);
		System.out.println(params);

		return params;
	}

	/* /comments?boardId=xxx/ comments/xx */
	@GetMapping(value = "/comments")
	@ResponseBody
	public List<CommentDTO> getCommentList(@RequestParam("boardId") int boardId,Model model) {
//		System.out.println("getCommentList실행");
		CommentDTO CDTO = new CommentDTO();
		CDTO.setBoardId(boardId);
		List<CommentDTO> commentList = commentService.getCommentList(CDTO);
//		System.out.println("받아온 댓글 리스트 commentList : "+commentList);
		if (CollectionUtils.isEmpty(commentList) == false) {
//			System.out.println("if문 안쪽 받아온 댓글 리스트 commentList :"+commentList);
			model.addAttribute("commentList", commentList);
		}
//		System.out.println("if문 끝나고 받아온 댓글 리스트 commentList :"+commentList);
		return commentList;
	}
	
	@DeleteMapping(value = "/comments/{id}")
	@ResponseBody
	public int deleteComment(@PathVariable("id") final int id ,
			@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
		
		
//		System.out.println("범인은 너냐?");
		try {
			boolean isDeleted = commentService.deleteComment(id);
			System.out.println(isDeleted);
			model.addAttribute("result", isDeleted);

		} catch (DataAccessException e) {
			model.addAttribute("message", "데이터베이스 처리 과정에 문제가 발생하였습니다.");

		} catch (Exception e) {
			model.addAttribute("message", "시스템에 문제가 발생하였습니다.");
		}
		model.addAttribute("userInfo", user);
//		System.out.println("범인은 너냐?");
		return id;
	}
	
    @GetMapping("/user/mycommentlist.do")
    public String openFreePostList(@ModelAttribute("params") final SearchDto params,
    		@SessionAttribute(name = "userInfo", required = false)UserResponse user,Model model) {
    	if(user == null) {
        	return "user/needLogin";
        }
    	params.setUserNo(user.getUserNo());
    	PagingResponse<UserCommentListDTO> response = commentService.UserCommentList(params);
    	model.addAttribute("response", response);
    	model.addAttribute("userInfo", user);
        return "user/MyCommentList";
    }
	

}