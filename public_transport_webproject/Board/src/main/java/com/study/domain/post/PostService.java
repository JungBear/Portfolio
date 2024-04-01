package com.study.domain.post;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.study.common.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public int savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public PostResponse findById(final Long id) {
        return postMapper.findById(id);
    }    
    
//    /**
//     * 정보 게시글 상세정보 조회
//     * @param id - PK
//     * @return 게시글 상세정보
//     */
//    public PostResponse findByInfoTypeId(final Long id) {
//        return postMapper.findByInfoTypeId(id);
//    }
//    
//    /**
//     * 자유 게시글 상세정보 조회
//     * @param id - PK
//     * @return 게시글 상세정보
//     */
//    public PostResponse findByFreeTypeId(final Long id) {
//        return postMapper.findByFreeTypeId(id);
//    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public int updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @param params - search conditions
     * @return 게시글 리스트
     */
//    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {
//
//        int count = postMapper.count(params);
//        if (count < 1) {
//            return new PagingResponse<>(Collections.emptyList(), null);
//        }
//
//        Pagination pagination = new Pagination(count, params);
//        params.setPagination(pagination);
//
//        List<PostResponse> list = postMapper.findAll(params);
//        return new PagingResponse<>(list, pagination);
//    }
    /**
     * 정보 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public PagingResponse<PostResponse> findInfoPost(final SearchDto params) {

        int count = postMapper.infoCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findInfo(params);
        return new PagingResponse<>(list, pagination);
    }
    
    /**
     * 자유 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public PagingResponse<PostResponse> findFreePost(final SearchDto params){
    	int count = postMapper.freeCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findFree(params);
        return new PagingResponse<>(list, pagination);
    }
    
	public PagingResponse<PostResponse> UserPostList(final SearchDto params){
		int count = postMapper.userPostListCount(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);
        System.out.println("여까지됨?");
        List<PostResponse> list = postMapper.userPostList(params);
        System.out.println("얘가안되나보네");
		return new PagingResponse<>(list, pagination);
	}
    
    
    
    
    

}