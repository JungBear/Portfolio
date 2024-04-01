package com.study.common.dto;


import java.util.Map;

import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDto {

    private String message;                // 사용자에게 전달할 메시지
    private String redirectUri;            // 리다이렉트 URI
    private RequestMethod method;          // HTTP 요청 메서드
    private Map<String, Object> data;      // 화면(View)으로 전달할 데이터(파라미터)

}