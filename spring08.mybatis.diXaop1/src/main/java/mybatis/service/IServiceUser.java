package mybatis.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelUser;

public interface IServiceUser {

  //유저의 수를 구하기
    public abstract int getUserTotalNumber();
    
    //유저 추가(C)
    public abstract int insertUser(Map<String, Object> user);
    
    //유저 로그인
    public abstract ModelUser login(ModelUser user);
    
    //유저 로그아웃
    public abstract ModelUser logout(String user);
    
    //유저 삭제(D)
    public abstract int DeleteUser(String userno);
    
    //유저 수정(U)
    public abstract int setUserUpdate(HashMap<String, Object> hashmap);
    
    //아이디 중복 확인
    public abstract ModelUser setUserOverlap(String userid);
    
    //패스워드 업데이트
    public abstract int updatePasswd(ModelUser passwd);
    
    //셀렉트 유저 1
    public abstract ModelUser selectUserOne(ModelUser user);
    
    //셀렉트 유저 리스트
    public abstract List<ModelUser> selectUserList(ModelUser user);
    
    //업데이트 유저 정보
    public abstract int updateUserInfo(ModelUser user);
    
}
