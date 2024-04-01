package com.study.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

@Mapper
public interface PostMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * 
     * void는 return 값이 없는 함수.
     * 오랜만에 보니 뭐지 했네..
     * 
     */
    void save(PostRequest params);
    
    /**
     * 모든 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostResponse findById(Long id);
    
    /**
     * 정보 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
//    PostResponse findByInfoTypeId(Long id);
//    
//    /**
//     * 자유 게시글 상세정보 조회
//     * @param id - PK
//     * @return 게시글 상세정보
//     */
//    PostResponse findByFreeTypeId(Long id);
//    
    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 모든 게시글 리스트 조회
     * @return 게시글 리스트
     */
//    List<PostResponse> findAll(SearchDto params);
    
    /**
     * 정보 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findInfo(SearchDto params);
    
    /**
     * 자유 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostResponse> findFree(SearchDto params);
   
    
    /**
     * 정보 게시글 수 카운팅
     * @return 게시글 수
     */
    int infoCount(SearchDto params);
    
    /**
     * 자유 게시글 수 카운팅
     * @return 게시글 수
     */
    int freeCount(SearchDto params);
    
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
  
   /*
    * 마이페이지 내 글보기
    * @return 요약정보게시글 리스트
    * */
   List<PostResponse> userPostList(SearchDto params);
   
   int userPostListCount(SearchDto params);


}