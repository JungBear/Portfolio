package com.study.domain.comment;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public boolean registerComment(CommentDTO params) {
		int queryResult = 0;

		if (params.getId() == 0) {
			System.out.println("서비스 인서트 실행전");
			queryResult = commentMapper.insertComment(params);
		} else {
			queryResult = commentMapper.updateComment(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public boolean deleteComment(int id) {
		int queryResult = 0;

		CommentDTO comment = commentMapper.selectCommentDetail(id);

		if (comment != null && comment.getDelYn() == 0) {
			queryResult = commentMapper.deleteComment(id);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<CommentDTO> getCommentList(CommentDTO params) {
		List<CommentDTO> commentList = Collections.emptyList();

		int commentTotalCount = commentMapper.commentCount(params);
		if (commentTotalCount > 0) {
			commentList = commentMapper.selectCommentList(params);
		}

		return commentList;
	}
	
	@Override
	public PagingResponse<UserCommentListDTO> UserCommentList(final SearchDto params){
		int count = commentMapper.UserCommentListCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);
        System.out.println("여까지됨?");
        List<UserCommentListDTO> list = commentMapper.UserCommentList(params);
        System.out.println("얘가안되나보네");
		return new PagingResponse<>(list, pagination);
	}
}
