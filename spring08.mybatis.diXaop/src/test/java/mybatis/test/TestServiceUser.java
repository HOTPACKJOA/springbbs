package mybatis.test;

import static org.junit.Assert.*;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.model.ModelUser;
import mybatis.service.IServiceUser;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) //이름순으로 실행하겠다.
public class TestServiceUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceUser.class);
    
    private static SqlSession session = null;   // 없어도 됐던 것
    private static ApplicationContext context = null;
    private static IServiceUser ISU = null;
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        ISU = context.getBean("userservice", IServiceUser.class);
    
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //((ClassPathXmlApplicationContext)context).close();
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void test() {
    }
    
    @Test
    public void insertUserTest() { //완료
        //IServiceUser ISU = new ServiceUser();
        
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("userid", "abcde");
        user.put("passwd", "abcde");
        user.put("email", "bbcde");
        user.put("name", "esBde");
        user.put("mobile", "1111123");
        user.put("insertdt", new Date());
        
        int result = -1;
        result = ISU.insertUser(user);
        
        assertSame(result, 1);
    }
    
    @Test
    public void setUserOverlapTest(){ //완료
        //IServiceUser ISU = new ServiceUser();
        
        String userid = "abc";
        
        ModelUser result = ISU.setUserOverlap(userid);
        
        assertEquals(result.getUserid(), "abc");
    }
    
    @Test
    public void loginTest(){  //완료
        
        
        ModelUser user = new ModelUser();
        user.setUserid("abcd");
        user.setPasswd("abcd");
        
        ModelUser result = null;
        result = ISU.login(user);
        
        assertEquals(result.getName(), "esBd");
    }
    
    @Test
    public void deleteUserTest(){ //완료
        
        
        int result = -1;
        result = ISU.DeleteUser("abc");
        
        assertSame(result, 1);
        
    }
    
    @Test
    public void selectUserOneTest(){ //완료
        //IServiceUser ISU = new ServiceUser();
        
        //userid name mobile
        ModelUser user = new ModelUser();
        user.setUserid("abc");
        user.setName(null);
        user.setMobile(null);
        
        ModelUser result = null;
        result = ISU.selectUserOne(user);
        
        assertSame(result.getUserno(), 1);
        
    }
    
    @Test
    public void updateUserInfoTest(){ //완료
        //IServiceUser ISU = new ServiceUser();
        
        ModelUser user = new ModelUser();
        user.setUserid("abc");
        user.setUpdatedt(new Date());
        user.setPasswd("abc");
        user.setUpdateuid("ABABABABAB");
        
        int result = ISU.updateUserInfo(user);
        
        assertSame(result , 1);
    }
    
    @Test
    public void updatePasswdTest(){ //완료
        //IServiceUser ISU = new ServiceUser();
        
        ModelUser user = new ModelUser();
        user.setUserid("abc");
        user.setUpdatedt(new Date());
        user.setPasswd("abc");
        user.setUpdateupw("KKKKK");
        
        int result = ISU.updatePasswd(user);
        
        assertSame(result , 1);
    }
}
