package mybatis.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mybatis.model.ModelBook;

@Repository
public class DAOBook implements IDAOBook {

    @Autowired
    private SqlSession session;

    public SqlSession getsession() {
        return session;
    }

    public void setsession(SqlSession session) {
        this.session = session;
    }  
    

    public DAOBook(SqlSession session) {
        super();
        this.session = session;
    }

    public DAOBook() {
        super();
    }
    
    
    
    
  
    @Override
    public List<ModelBook> getSQLSelectAll() throws SQLException {
        
        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectAll");
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectLike(String bookname)
            throws SQLException {
        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectLike", "%" + bookname + "%" );
        
        return result;
    }

    @Override
    public List<ModelBook> getSQLSelectEqual(String bookname)
            throws SQLException {

        List<ModelBook> result  = null;
        
        result = session.selectList("mybatis.mapper.mapperBook.getSQLSelectEqual", bookname );
        
        return result;
    }

    @Override
    public int setSQLInsert(ModelBook book) throws SQLException {
        
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsert", book);        
        return result;
    }

    @Override
    public int setSQLInsertMulti(List<ModelBook> books) throws SQLException {
        
        int result = 0 ;
        result = session.insert("mybatis.mapper.mapperBook.setSQLInsertMulti", books);        
        return result;
    }

    @Override
    public int setSQLInsertSequence(String bookname,
            String publisher, String year, int price, String dtm,
            boolean use_yn, int authid) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int setSQLUpdate(ModelBook updateValue, ModelBook searchValue) throws SQLException {
        
        int result = 0;
        
        Map<String, ModelBook> parameter = new HashMap<String, ModelBook>();

        parameter.put("updateValue"       , updateValue  );
        parameter.put("searchValue"       , searchValue  );
      
        result = session.update("mybatis.mapper.mapperBook.setSQLUpdate", parameter);
        
        return result;
    }

    @Override
    public int setSQLDelete(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }


    
}