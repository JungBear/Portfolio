package com.study;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setType(1);
        params.setTitle("정보게시판 1번 게시글 제목");
        params.setContent("정보게시판 1번 게시글 내용");
        params.setWriterNo(1);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findFree(null);
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

    @Test
    void findByInfoTypeId() {
        PostResponse post = postMapper.findByInfoTypeId(2L);
        try {
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
   
    
//    @Test
//    void update() {
//        // 1. 게시글 수정
//        PostRequest params = new PostRequest();
//        params.setId(2L);
//        params.setTitle("1번 게시글 제목 수정합니다.");
//        params.setContent("1번 게시글 내용 수정합니다.");
//        postMapper.update(params);
// 
//        // 2. 게시글 상세정보 조회
//        PostResponse post = postMapper.findByFreeTypeId(2L);
//        try {
//            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
//            System.out.println(postJson);
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Test
//    void delete() {
//        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postMapper.findAllPost().size() + "개입니다.");
//        postMapper.deleteById(3L);
//        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postMapper.findAllPost().size() + "개입니다.");
//    }
}