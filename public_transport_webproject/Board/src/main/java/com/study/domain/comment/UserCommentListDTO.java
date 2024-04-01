package com.study.domain.comment;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserCommentListDTO {

	//user 
	private int userNo;
	// postDTO
	private int id;     
    private int type;  
    private String title;
	
    // commentDTO
	private int commentId;
	private int boardId;
	private int boardType;
	private String content;
	private int cdepth;
	private int groupNo;
	private int corder;
	private int writerNo;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int delYn;
	private LocalDateTime delDate;
	private int secret;
	private String nickname;
}
