package com.study.domain.comment;

import java.util.List;

import com.study.common.dto.SearchDto;
import com.study.paging.PagingResponse;

public interface CommentService {

	public boolean registerComment(CommentDTO params);

	public boolean deleteComment(int id);

	public List<CommentDTO> getCommentList(CommentDTO params);

	public PagingResponse<UserCommentListDTO>UserCommentList(SearchDto params);
}