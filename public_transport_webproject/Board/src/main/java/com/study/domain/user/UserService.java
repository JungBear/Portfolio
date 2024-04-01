package com.study.domain.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.post.PostRequest;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
	
	
	private final UserMapper userMapper;
    
    /**
     * 아이디체크
     * @param params - 아이디 정보
     * @return  true, false
     */
    public boolean getId(UserRequest params) {
        int n = userMapper.getId(params);
        return n > 0;
    }
    
    /**
     * 닉네임체크
     * @param params - 닉네임 정보
     * @return  true, false
     */
    public boolean getNickname(UserRequest params) {
        int n = userMapper.getNickname(params);
        return n > 0;
    }
    
    /**
     * 회원가입
     * @param params - 사용자가 작성한 정보
     * @return  true, false
     */
    @Transactional
    public boolean addMember(UserRequest params) {
        int n = userMapper.addMember(params);
        return n > 0;
    }
    
    /*
     * 로그인
     */
    public UserResponse login(UserResponse params) throws Exception {
        return userMapper.login(params);
    }
    
    public UserRequest findId(UserRequest params) {
    	return userMapper.findId(params);
    }
    
    
   public UserRequest findPwd(UserRequest params) {
	   return userMapper.findPwd(params);
   }
   
   /**
    * 마이페이지 전 비번확인
    * @param params - 비밀번호
    * @return  비밀번호
    */
   boolean checkPwd(UserRequest params) {
	   if(userMapper.checkPwd(params) != null) {
		   return true;
	   }else {
		   return false;
	   }
	   
   };
   
   /**
    * 회원탈퇴
    * @param params - 사용자번호
    * @return  사용자번호
    */
   public int deleteUser(final int id) {
	   userMapper.deleteUser(id);
       return id;
   }
   
   /**
    * 회원 수정
    * @param params - 유저 정보
    * @return PK
    */
   @Transactional
   public int modifyUser(final UserRequest params) {
       userMapper.modifyUser(params);
       return params.getUserNo();
   }
  
   /**
    * 비밀번호 변경
    * @param params - 유저 정보
    * @return PK
    */
   @Transactional
   public int changePwd(final UserRequest params) {
       userMapper.changePwd(params);
       return params.getUserNo();
   }
   
    public List<UserRequest> getAll(){
    	return userMapper.selectAll();
    }
    
    
    //넘겨받은 id 파라미터로 selectOne 메서드 실행
    public List<UserRequest> getOne(String id){
    	return userMapper.selectOne(id);
    }
    
    
    
}
