package spring04.mybatis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mybatis.model.ModelBook;
import mybatis.service.IServiceBook;
import mybatis.service.ServiceBook;

public class TestServiceBook {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBook.class);
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetSelectAll() {
        IServiceBook service = new ServiceBook();
        List<ModelBook> result = service.getSQLSelectAll();
        
        assertSame(result.size(), 10);
    }
    
    @Test
    public void testGetSelectLike() {
        IServiceBook service = new ServiceBook();
        List<ModelBook> result = service.getSQLSelectLike("SQL");
        
        assertSame(result.size(), 1);
    }
    
    @Test
    public void testGetSelectEqual() {
        IServiceBook service = new ServiceBook();
        List<ModelBook> result = service.getSQLSelectEqual("JAVA");
        
        assertSame(result.size(), 1);
    }
    
    @Test
    public void testSetSQLInsert() {
        ModelBook book = new ModelBook();
        book.setAuthid(23);
        book.setBookname("ABC");
        book.setDtm("2015-02-02");
        book.setPrice(10000);
        book.setPublisher("BBC");
        book.setUse_yn(true);
        book.setYear("1234");
        
        IServiceBook service = new ServiceBook();
        int result = service.setSQLInsert(book);
        assertSame(result, 1);
        
        
    }
}
