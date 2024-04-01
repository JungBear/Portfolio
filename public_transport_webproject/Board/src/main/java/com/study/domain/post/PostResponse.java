package com.study.domain.post;

import java.time.LocalDateTime;

import lombok.Data;
//DTO = response + request
@Data
public class PostResponse {
	
	private int userNo;
    private int id;               // PK
    private int type;                 //게시글 분류
    private String title;                  // 제목
    private String content;                // 내용
    private int writerNo;                 // 작성자
    private String nickname;		// 닉네임
    private int notice;              // 공지글 여부
    private int delYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시 
    private LocalDateTime modifiedDate;    // 최종 수정일시
    private LocalDateTime delDate;
    private int countGood;
    private int countBad;

}