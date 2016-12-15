package mybatis.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import mybatis.model.ModelBook;

public interface IDAOBook {
    
    List<ModelBook> getSQLSelectAll() throws SQLException;
    
    List<ModelBook> getSQLSelectLike(String bookname)
            throws SQLException;
    
    List<ModelBook> getSQLSelectEqual(String bookname)
            throws SQLException;
    
    int setSQLInsert(ModelBook book) throws SQLException;
    
    int setSQLInsertMulti(List<ModelBook> books) throws SQLException;
    
    int setSQLInsertSequence(String bookname, String publisher,
            String year, int price, String dtm, boolean use_yn, int authid)
            throws SQLException;
    
    int setSQLUpdate(ModelBook updateValue, ModelBook searchValue)
            throws SQLException;
    
    int setSQLDelete(ModelBook book) throws SQLException;
}
