package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelComments {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ModelComments.class);
    
    Integer commentno   ;
    Integer articleno  ;
    String email  ;
    String memo    ;
    Date regdate    ;
    Boolean useyn  ;
    String insertuid  ;
    Date insertdt   ;
    String updateuid ;
    Date updatedt   ;
    public Integer getCommmentno() {
        return commentno;
    }
    public void setCommmentno(Integer commmentno) {
        this.commentno = commmentno;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Boolean getUseyn() {
        return useyn;
    }
    public void setUseyn(Boolean useyn) {
        this.useyn = useyn;
    }
    public String getInsertuid() {
        return insertuid;
    }
    public void setInsertuid(String insertuid) {
        this.insertuid = insertuid;
    }
    public Date getInsertdt() {
        return insertdt;
    }
    public void setInsertdt(Date insertdt) {
        this.insertdt = insertdt;
    }
    public String getUpdateuid() {
        return updateuid;
    }
    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }
    public Date getUpdatedt() {
        return updatedt;
    }
    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }
    public ModelComments(Integer commmentno, Integer articleno, String email,
            String memo, Date regdate, Boolean useyn, String insertuid,
            Date insertdt, String updateuid, Date updatedt) {
        super();
        this.commentno = commmentno;
        this.articleno = articleno;
        this.email = email;
        this.memo = memo;
        this.regdate = regdate;
        this.useyn = useyn;
        this.insertuid = insertuid;
        this.insertdt = insertdt;
        this.updateuid = updateuid;
        this.updatedt = updatedt;
    }
    public ModelComments() {
        super();
    }
    @Override
    public String toString() {
        return "ModelComments [commmentno=" + commentno + ", articleno="
                + articleno + ", email=" + email + ", memo=" + memo
                + ", regdate=" + regdate + ", useyn=" + useyn + ", insertuid="
                + insertuid + ", insertdt=" + insertdt + ", updateuid="
                + updateuid + ", updatedt=" + updatedt + "]";
    }
    
    
}
