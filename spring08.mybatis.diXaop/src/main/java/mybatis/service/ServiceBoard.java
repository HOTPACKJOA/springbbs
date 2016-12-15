package mybatis.service;

import java.sql.SQLException;
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

import mybatis.dao.*;
import mybatis.model.*;

@Service("boardService")
public class ServiceBoard implements IServiceBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ServiceBoard.class);

    //public static SqlSessionFactory sqlMapper = MyBatisManager.getInstance();
    
    @Autowired
    @Qualifier("boardDao")
    IDaoBoard dao;
    

    public IDaoBoard getDaoboard() {
        return dao;
    }

    public void setDaoboard(IDaoBoard daoboard) {
        dao = daoboard;
    }

    public ServiceBoard(IDaoBoard daoboard) {
        super();
        dao = daoboard;
    }

    public ServiceBoard() {
        super();
    }
    
    
    @Override
    public String getBoardName(String boardcd) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        
        String result = null;
            result = dao.getBoardName(boardcd);
        return result;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        //SqlSession session = sqlMapper.openSession();
        
        ModelBoard result = null;
        
        result = dao.getBoardOne(boardcd);
       
        return result;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<ModelBoard> getBoardList() {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelBoard> result = null;
        result = dao.getBoardList();
        
        return result;
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        Map<String, ModelBoard> result = null;
        result = dao.getBoardListResultMap();
        
        return result;
        
    }

    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
            result = dao.insertBoard(board);
            return result;
               
    }

    @Override
    public int updateBoard(ModelBoard updateValue, ModelBoard searchValue) throws SQLException {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
          // session
        int result = -1;
        result = dao.updateBoard(updateValue, searchValue);
        
        return result;
    }

    @Override
    public int deleteBoard(String boardcd) throws SQLException {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.deleteBoard(boardcd);
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard boardcd) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelBoard> result = null;
        result = dao.getBoardSearch(boardcd);
        
        return result;
    }

    @Override
    public List<ModelBoard> getBoardPaging(int start, int end, String searchValue) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelBoard> result = null;
        result = dao.getBoardPaging(start, end, searchValue);
        return result;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.insertBoardList(list);
        
        return result;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardCd, String searchWord,
            int start, int end) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelArticle> result = dao.getArticleList(boardCd, searchWord, start, end);
        return result;
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        ModelArticle result = null;
        result = dao.getArticle(articleNo);
                dao.increaseHit(articleNo); // 열람을 하면 히트를 1개 올리는 코드
        
        return result;
    }

    @Override
    public int getArticleTotalRecord(String boardCd, String searchWord) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.getArticleTotalRecord(boardCd, searchWord);
        
        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.insertArticle(article);
        
        return result;
    }

    @Override
    public int updateArticle(ModelArticle Search, ModelArticle Replace) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.updateArticle(Search, Replace);
        
        return result;
    }

    @Override
    public int deleteArticle(int articleNo) {  //ModelArticle article 바꾸라고 함.
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.deleteArticle(articleNo);
        
        return result;
    }

    @Override
    public int increaseHit(int articleNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.increaseHit(articleNo);
        
        return result;
    }

    @Override
    public ModelArticle getNextArticle(int articleno, String boardCd, String searchWord) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("articleno", articleno);
        map.put("boardcd", boardCd);
        map.put("searchWord", "%" + searchWord + "%");
        
        ModelArticle result = null;
        result = dao.getNextArticle(map);
        
        return result;
    }

    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd,
            String searchWord) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("articleno", articleno);
        map.put("boardcd", boardcd);
        map.put("searchWord", "%" + searchWord + "%");
        
        ModelArticle result = null;
        result = dao.getPrevArticle(map);
        
        return result;
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelAttachfile> result = null;
        result = dao.getAttachFileList(articleNo);
        
        return result;
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        ModelAttachfile result = null;
        result = dao.getAttachFile(attachFileNo);
        
        return result;
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.insertAttachFile(attachFile);
        
        return result;
    }

    @Override
    public int deleteAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.deleteAttachFile(attachFileNo);
        
        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        List<ModelComments> result = null;
        result = dao.getCommentList(articleNo);
        
        return result;
    }

    @Override
    public ModelComments getComment(int commentNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        ModelComments result = null;
        result = dao.getComment(commentNo);
        
        
        return result;
    }

    @Override
    public int insertComment(ModelComments comment) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.insertComment(comment);
        
        return result;
    }

    @Override
    public int updateComment(ModelComments comment) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.updateComment(comment);
        
        return result;
    }

    @Override
    public int deleteComment(int commentNo) {
        // TODO Auto-generated method stub
        //SqlSession session = sqlMapper.openSession();
        
        int result = -1;
        result = dao.deleteComment(commentNo);
        
        return result;
    }

}
