package com.study;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.comment.CommentDTO;
import com.study.domain.comment.CommentService;



@SpringBootTest
class CommentTests {

	@Autowired
	private CommentService commentService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void registerComments() {
		int number = 3;

		for (int i = 1; i <= number; i++) {
			CommentDTO params = new CommentDTO();
			params.setBoardId(1); // 댓글을 추가할 게시글 번호
			params.setBoardType(0);
			params.setContent(i + "번 댓글을 추가합니다!");
			params.setWriterNo(1);
			params.setSecret(0);
			commentService.registerComment(params);
		}

		logger.debug("댓글 " + number + "개가 등록되었습니다.");
	}

	@Test
	public void deleteComment() {
		commentService.deleteComment(10); // 삭제할 댓글 번호
		getCommentList();
	}

	@Test
	public void getCommentList() {
		CommentDTO params = new CommentDTO();
		params.setBoardId(12); // 댓글을 추가할 게시글 번호

		commentService.getCommentList(params);
	}

}