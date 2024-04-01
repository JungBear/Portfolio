package com.study.domain.main;

import java.util.List;

import com.study.domain.post.PostResponse;

public interface MainService {
	public List<BridgeDTO> getcongestionRate(BridgeDTO params);
	
    /*
     * 메인페이지 정보게시글 요약
     * @return 요약정보게시글 리스트
     * */
   List<PostResponse> summaryInfoList();
   
   /*
    * 메인페이지 정보게시글 요약
    * @return 요약정보게시글 리스트
    * */
  List<PostResponse> summaryFreeList();

}
