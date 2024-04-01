package com.study.domain.post;

import lombok.Data;

@Data
public class PostRequest {

    private int id;             // PK
    private int type;            // 게시글의 타입
    private String title;        // 제목
    private String content;      // 내용
    private int writerNo;    // 작성자
    private int notice;    // 공지글 여부
    
}    