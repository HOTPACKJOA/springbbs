package mybatis.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;
import mybatis.service.IServiceBoard;

public class TestServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory
            .getLogger(TestServiceBoard.class);
    
    private static ApplicationContext context = null;
    private static IServiceBoard board = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        board = context.getBean("boardService", IServiceBoard.class);
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
    public void test() {
        
    }
    
    @Test
    public void getBoardName() { //완료
        
        String result = board.getBoardName("free");
        assertEquals(result, "자유게시판");
    }

    @Test
    public void getBoardOne() { //완료
            
        ModelBoard result = null;
        result = board.getBoardOne("free");
        assertEquals(result.getBoardnm(), "자유게시판");
    }

    @Test
    public void getBoardTotalRecord() {
    }

    @Test
    public void getBoardList() { //완료
        
        List<ModelBoard> result = null;
        result = board.getBoardList();
        assertSame(result.size(), 3);
    }

    @Test
    public void getBoardListResultMap() { //완료
        
        Map<String, ModelBoard> result = null;
        result = board.getBoardListResultMap();
        assertSame(result.size(), 3);
        assertEquals(result.get("free").getBoardnm(), "자유게시판");
        
    }

    @Test
    public void insertBoard() { //완료
        
        int result = 0;
        
        
        ModelBoard ins = new ModelBoard();
        ins.setBoardcd("CD");
        ins.setBoardnm("NM");
        //ins.setInsertDT("2016-02-02");
        //ins.setInsertUID("UID");
        //ins.setUpdateDT("2015-02-02");
        //ins.setUpdateUID("UIDD");
        ins.setUseYN(true);
        
        
        
        try {
            result = board.insertBoard(ins);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBoard" + e.getMessage() );
        }
        assertSame(result, 1);
    }

    @Test
    public void updateBoard() { //완료
        
        int result = 0;
        
        ModelBoard updateValue = new ModelBoard();
        updateValue.setUpdateUID("CCDD");
        
        ModelBoard searchValue = new ModelBoard();
        searchValue.setBoardnm("NM");
        
        try {
            result = board.updateBoard(updateValue, searchValue);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBoard" + e.getMessage() );
        }
        
        assertSame(result, 1);
        
    }

    @Test
    public void deleteBoard() { //완료
        
        int result = 0;
        try {
            result = board.deleteBoard("CD");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBoard" + e.getMessage() );
        }
        assertSame(result, 1);
    }

    @Test
    public void getBoardSearch() { //완료
        
        
        ModelBoard abc = new ModelBoard();
        abc.setBoardcd("qna");
        abc.setBoardnm("QnA");
        
        List<ModelBoard> result = null;
        result = board.getBoardSearch(abc);
        assertSame(result.size(), 1);
    }

    @Test
    public void getBoardPaging() { //완료
        
        List<ModelBoard> result = null;
        result = board.getBoardPaging(3, 9, "");
        
        assertSame(result.size(), 7);
        
    }

    @Test
    public void insertBoardList() { //완료
        
        
        List<ModelBoard> IBL = new ArrayList<ModelBoard>();
        
        Date ddd = new Date();
        double random = Math.floor(Math.random()*10) ;
        
        for( int i=0; i <= 5; i=i+1 ){
            ModelBoard abc = new ModelBoard();
            abc.setBoardcd("ABCD"+ i + "_" + ddd.getDate() + "_" + ddd.getHours() + "_" + ddd.getMinutes() + "_" + ddd.getSeconds());
            abc.setBoardnm("BDFd");
            abc.setUseYN(true);
            
            IBL.add( abc ); 
        }
        
        int result = 0;
        result = board.insertBoardList(IBL);
        
        assertSame(result, 1);
    }

    @Test
    public void getArticleList() { //완료
        
        String boardcd = "free";
        String searchWord = "article";
        int start = 2;
        int end = 7;
        List<ModelArticle> result = board.getArticleList(boardcd, searchWord, start, end);
        assertEquals(result.size(), 6);
    }

    @Test
    public void getArticle() { //완료
        
        ModelArticle result = null;
        result = board.getArticle(1);
        assertEquals(result.getTitle(), "article test 01");
    }

    @Test
    public void getArticleTotalRecord() { //완료
        
        int result = 0;
        result = board.getArticleTotalRecord("free", "article test");
        
        assertSame(result, 14);
        
    }

    @Test
    public void insertArticle() { //완료
        
        ModelArticle matl = new ModelArticle();
        matl.setBoardcd("AB");
        matl.setTitle("CD");
        matl.setContent("EF");
        matl.setEmail("GG@GG.GG.GG");
        //matl.setHit();
        matl.setRegdate(null);
        matl.setArticleno(2);
        matl.setUseyn(true);
        
        int result = 0;
        result = board.insertArticle(matl);
        
        assertSame(result, 1);
    }

    @Test
    public void updateArticle() { //완료
        
        ModelArticle Search = new ModelArticle();
        Search.setArticleno(1);
        ModelArticle Replace = new ModelArticle();
        Replace.setTitle("ABC");
        Replace.setContent("KKK");
        
        int result = 0;
        result = board.updateArticle(Search, Replace);
        
        assertSame(result, 1);
        
    }

    @Test
    public void deleteArticle() { //완료
        
        int result = -1;
        result = board.deleteArticle(14);
        
        assertSame(result, 1);
    }

    @Test
    public void increaseHit() { //완료
        
        int result = -1;
        result = board.increaseHit(4);
        
        assertSame(result, 1);
    }

    @Test  
    public void getNextArticle() {         // 완료
        
        int articleno = 5; 
        String boardcd = "free";
        String searchWord = "article test";
        
        ModelArticle result = null;
        result = board.getNextArticle(articleno, boardcd, searchWord);
        assertSame(result.getArticleno(), 6);
    }

    @Test  
    public void getPrevArticle() { // 완료
        
        int articleno = 5; 
        String boardcd = "free";
        String searchWord = "article test";
        
        ModelArticle result = null;
        result = board.getPrevArticle(articleno, boardcd, searchWord);
        assertSame(result.getArticleno(), 4);
    }

    @Test
    public void getAttachFileList() { //완료
        
        List<ModelAttachfile> result = null;
        result = board.getAttachFileList(40);
        
        assertSame(result.size(), 1);
    }

    @Test
    public void getAttachFile() { //완료
        
        ModelAttachfile result = null;
        result = board.getAttachFile(2);
        assertEquals(result.getFiletype(), "AAAAA");
        
    }

    @Test
    public void insertAttachFile() { //완료
        
        ModelAttachfile maf = new ModelAttachfile();
        maf.setFilename("ABC");
        maf.setFiletype("AAAAA");
        maf.setFilesize(30);
        maf.setArticleno(40);
        int result = -1;
        result = board.insertAttachFile(maf);
        
        assertSame(result, 1);
        
    }

    @Test
    public void deleteAttachFile() { //완료
        
        int result = -1;
        result = board.deleteAttachFile(2);
        
        assertSame(result, 1);
        
    }

    @Test
    public void getCommentList() { //완료
        
        int articleno = 1;
        List<ModelComments> result = board.getCommentList(articleno);
        assertEquals(result.size(), 1);
        
    }

    @Test
    public void getComment() { //완료
        
        ModelComments result = null;
        result = board.getComment(1);
        assertEquals(result.getEmail(), "aa@aa.co.kr");
    }

    @Test
    public void insertComment() { //완료
        //articleno, email, memo, regdate
        
        ModelComments mc = new ModelComments();
       
        mc.setArticleno(3);
        mc.setEmail("BB@BB.co.kr");
        mc.setMemo("ABCFEFQ");
        mc.setRegdate(new Date());
        
        int result = -1;
        result = board.insertComment(mc);
        
        assertSame(result, 1);
    }

    @Test
    public void updateComment() { //완료
        
        //memo commentno
        ModelComments searchValue = new ModelComments();
        searchValue.setCommmentno(1);
        ModelComments updateValue = new ModelComments();
        searchValue.setMemo("MEMOMEMO");
        
        
        int result = -1;
        result = board.updateComment(searchValue);
        
        assertSame(result, 1);
    }

    @Test
    public void deleteComment() { //완료
        
        int result = -1;
        result = board.deleteComment(21);
        
        assertSame(result, 1);
        
    }
    
    
}
