package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelUser;

@Repository("userDao")
//영속성을 가지는 계층 (데이터 접근 계층) 의 컴포넌트에 대해 선언한다.
public class DaoUser implements IDaoUser {
    
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoUser.class);

    @Autowired
    @Qualifier("sqlSession")
    //<property name="session" ref="session" />
    public SqlSession session;
    //dao의 session 은 남겨둔다.
    public SqlSession getsession() {
        return session;
    }

    public void setsession(SqlSession session) {
        this.session = session;
    }

    public DaoUser(SqlSession session) {
        super();
        this.session = session;
    }

    public DaoUser() {      //필수
        super();
    }

    
    @Override
    public int getUserTotalNumber() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertUser(Map<String, Object> user) {
        // TODO Auto-generated method stub
        return session.insert("mybatis.model.mapperUser.insert", user);
        
    }

    @Override
    public ModelUser login(ModelUser user) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.model.mapperUser.login", user);
        
    }

    @Override
    public ModelUser logout(String user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int DeleteUser(String userno) {
        // TODO Auto-generated method stub
        return session.update("mybatis.model.mapperUser.deleteUser", userno);
    }

    @Override
    public int setUserUpdate(HashMap<String, Object> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ModelUser setUserOverlap(String userid) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.model.mapperUser.setUserOverlap", userid);
        
    }

    @Override
    public int updatePasswd(ModelUser passwd) {
        // TODO Auto-generated method stub
        return session.update("mybatis.model.mapperUser.updatePasswd", passwd);
        
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.model.mapperUser.selectUserOne", user);
        
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateUserInfo(ModelUser user) {
        // TODO Auto-generated method stub
        return session.update("mybatis.model.mapperUser.updateUserInfo", user);
        
    }

    
    
    
}
