package com.study.domain.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

@Mapper
public interface CommentMapper {
	
	/*
	 * @param = 댓글정보
	 */
	public int insertComment(CommentDTO params);

	/*
	 * @param = 댓글번호
	 */
	public CommentDTO selectCommentDetail(int id);

	public int updateComment(CommentDTO params);

	public int deleteComment(int id);

	public List<CommentDTO> selectCommentList(CommentDTO params);

	public int commentCount(CommentDTO params);
	
	public int UserCommentListCount(SearchDto params);
	
	/*
	 * 나의 댓글리스트 출력
	 */
	public List<UserCommentListDTO> UserCommentList(SearchDto params);
}
