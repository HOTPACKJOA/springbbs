package mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.dao.DaoUser;
import mybatis.dao.IDaoUser;
import mybatis.dao.MyBatisManager;
import mybatis.model.ModelUser;

@Service("userservice")
//컨테이너에서 id가 userservice라는 빈을 생성하고 해당 빈은 serviceUser 클래스를 가리킨다는 의미다.
//<bean id="userservice’class="com.apress.isf.spring.annotated.service.serviceUser"/>
public class ServiceUser implements IServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceUser.class);
    
    //public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();
    
    @Autowired
    //스프링 컨테이너가 실제로 인스턴스를 생성하여 선언된 변수에 대입하도록 만든다.
    //<property name="dao" ref="dao" />
    @Qualifier("userDao")
    IDaoUser dao;

    public IDaoUser getDao() {
        return dao;
    }

    public void setDao(IDaoUser dao) {
        this.dao = dao;
    }

    public ServiceUser(IDaoUser dao) {
        super();
        this.dao = dao;
    }

    public ServiceUser() {
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
        
        int result = -1;
        result = dao.insertUser(user);
        
        return result;
    }

    @Override
    public ModelUser login(ModelUser user) {
        // TODO Auto-generated method stub
        
        ModelUser result = null;
        result = dao.login(user);
        
        return result;
    }

    @Override
    public ModelUser logout(String user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int DeleteUser(String userno) {
        // TODO Auto-generated method stub
        
        int result = -1;
        result = dao.DeleteUser(userno);
        
        return result;
    }

    @Override
    public int setUserUpdate(HashMap<String, Object> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ModelUser setUserOverlap(String userid) {
        // TODO Auto-generated method stub
        
        
        
        ModelUser result = dao.setUserOverlap(userid);
        
        return result;
    }

    @Override
    public int updatePasswd(ModelUser passwd) {
        // TODO Auto-generated method stub
        // setUpdateupw
        
        int result = dao.updatePasswd(passwd);
        
        return result;
    }

    @Override
    public ModelUser selectUserOne(ModelUser user) {
        // TODO Auto-generated method stub
        
        ModelUser result = null;
        result = dao.selectUserOne(user);
       
        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateUserInfo(ModelUser user) {
        // TODO Auto-generated method stub
        
        int result = dao.updateUserInfo(user);
        
        return result;
    }


}
