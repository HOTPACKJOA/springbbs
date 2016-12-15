package mybatis.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelArticle;
import mybatis.model.ModelAttachfile;
import mybatis.model.ModelBoard;
import mybatis.model.ModelComments;

@Repository("boardDao")
public class DaoBoard implements IDaoBoard {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(DaoBoard.class);
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session; // = sqlMapper.openSession();   <-- IDaoBoard dao = new DaoBoard(session); 의 효과
    
    public SqlSession getsession() {
        return session;
    }

    public void setsession(SqlSession session) {
        this.session = session;
    }

    public DaoBoard(SqlSession session) {
        super();
        this.session = session;
    }
    
    public DaoBoard() {
        super();
    }
    
    

    @Override
    public int getBoardTotalRecord(HashMap<String, String> hashmap) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getBoardName(String boardcd) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getBoardName", boardcd);
        
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getBoardOne", boardcd);
        
        
    }

    @Override
    public List<ModelBoard> getBoardList() {
        // TODO Auto-generated method stub
        return session.selectList("mybatis.mapper.mapperBoard.getBoardList");
        
    }

    @Override
    public Map<String, ModelBoard> getBoardListResultMap() {
        // TODO Auto-generated method stub                                                    //map은 키 + 값
        return session.selectMap("mybatis.mapper.mapperBoard.getBoardListResultMap", "boardcd"); //중복되지 않는 키값에 해당되는 boardcd 
        
        
    }

    @Override
    public int insertBoard(ModelBoard board) throws SQLException {
        // TODO Auto-generated method stub
        return session.insert("mybatis.mapper.mapperBoard.insertBoard", board);
        
    }

    @Override
    public int updateBoard(ModelBoard updateValue, ModelBoard searchValue) throws SQLException {
        // TODO Auto-generated method stub
        
        Map<String, ModelBoard> parameter = new HashMap<String, ModelBoard>();

        parameter.put("updateValue", updateValue  );
        parameter.put("searchValue", searchValue  );
        
        return session.update("mybatis.mapper.mapperBoard.updateBoard", parameter);
        
    }

    @Override
    public int deleteBoard(String boardcd) throws SQLException {
        // TODO Auto-generated method stub
        return session.delete("mybatis.mapper.mapperBoard.deleteBoard", "%" + boardcd + "%");
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        // TODO Auto-generated method stub
        return session.selectList("mybatis.mapper.mapperBoard.getBoardSearch", board);
    }

    @Override
    public List<ModelBoard> getBoardPaging(int start, int end, String searchValue) {
        // TODO Auto-generated method stub
        
        Map<String, Object> gbp = new HashMap<String, Object>();
        gbp.put("start", start );
        gbp.put("end", end);
        gbp.put("searchValue", searchValue);
        
        return session.selectList("mybatis.mapper.mapperBoard.getBoardPaging", gbp);
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        // TODO Auto-generated method stub
        return session.insert("mybatis.mapper.mapperBoard.insertBoardList", list);
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        Map<String, String> parameter = new HashMap<String, String>();

        parameter.put("boardcd", boardcd  );
        parameter.put("searchWord", searchWord  );
        return session.selectOne("mybatis.mapper.mapperBoard.getArticleTotalRecord", parameter);
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,int start, int end) {
        // TODO Auto-generated method stub
        
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("boardcd", boardcd  );
        parameter.put("searchWord", searchWord  );
        parameter.put("start", start  );
        parameter.put("end", end  );
        
        return session.selectList("mybatis.mapper.mapperBoard.getArticleList", parameter);
    }

    @Override
    public ModelArticle getArticle(int articleNo) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getArticle", articleNo);
    }

    @Override
    public int insertArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return session.update("mybatis.mapper.mapperBoard.insertArticle", article);
    }

    @Override
    public int updateArticle(ModelArticle Search, ModelArticle Replace) {
        // TODO Auto-generated method stub
        
        Map<String, ModelArticle> parameter = new HashMap<String, ModelArticle>();
        parameter.put("updateValue", Replace  );
        parameter.put("searchValue", Search  );
        
        return session.update("mybatis.mapper.mapperBoard.updateArticle", parameter);
    }

    @Override
    public int deleteArticle(int articleNo) {
        // TODO Auto-generated method stub
        return session.delete("mybatis.mapper.mapperBoard.deleteArticle", articleNo);
        
    }

    @Override
    public int increaseHit(int articleNo) {
        // TODO Auto-generated method stub
        return session.update("mybatis.mapper.mapperBoard.increaseHit", articleNo);
        
    }

    @Override
    public ModelArticle getNextArticle(Map<String, Object> hashmap) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getNextArticle", hashmap);
        
    }

    @Override
    public ModelArticle getPrevArticle(Map<String, Object> hashmap) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getPrevArticle", hashmap);
        
    }

    @Override
    public ModelAttachfile getAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getAttachFile", attachFileNo);
        
    }

    @Override
    public List<ModelAttachfile> getAttachFileList(int articleno) {
        // TODO Auto-generated method stub
        return session.selectList("mybatis.mapper.mapperBoard.getAttachFileList", articleno);
        
    }

    @Override
    public int insertAttachFile(ModelAttachfile attachFile) { 
        // TODO Auto-generated method stub
        return session.insert("mybatis.mapper.mapperBoard.insertAttachFile", attachFile);
        
    }

    @Override
    public int deleteAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        return session.delete("mybatis.mapper.mapperBoard.deleteAttachFile", attachFileNo);
        
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleNo) {
        // TODO Auto-generated method stub
        return session.selectList("mybatis.mapper.mapperBoard.getCommentList", articleNo);
        
    }
    
    @Override
    public int insertComment(ModelComments comment) {
        // TODO Auto-generated method stub
        return session.insert("mybatis.mapper.mapperBoard.insertComment", comment);
        
        
    }

    @Override
    public int updateComment(ModelComments comment) {
        // TODO Auto-generated method stub
        return session.update("mybatis.mapper.mapperBoard.updateComment", comment);
        
    }

    @Override
    public int deleteComment(int commentNo) {
        // TODO Auto-generated method stub
        return session.delete("mybatis.mapper.mapperBoard.deleteComment", commentNo);
        
        
    }

    @Override
    public ModelComments getComment(int commentNo) {
        // TODO Auto-generated method stub
        return session.selectOne("mybatis.mapper.mapperBoard.getComment", commentNo);
        
    }



    
}
