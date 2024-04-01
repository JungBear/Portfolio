package com.study;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.post.PostRequest;
import com.study.domain.post.PostService;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save() {
        PostRequest params = new PostRequest();
        params.setType(0);
        params.setTitle("서비스테스트");
        params.setContent("서비스테스트");
        params.setWriterNo(1);
        postService.savePost(params);
    }

}