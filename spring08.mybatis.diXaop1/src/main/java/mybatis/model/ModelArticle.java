package mybatis.model;

import java.util.Date;

public class ModelArticle {
    
    Integer     articleno ;
    String  boardcd   ;
    String  title     ;
    String  content   ;
    String  email     ;
    Integer     hit       ;
    Date    regdate   ;
    boolean useyn     ;
    
    String  insertuid ;
    Date    insertdt  ;
    String  updateuid ;
    Date    updatedt  ;
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getHit() {
        return hit;
    }
    public void setHit(Integer hit) {
        this.hit = hit;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public boolean isUseyn() {
        return useyn;
    }
    public void setUseyn(boolean useyn) {
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
    
    
    @Override
    public String toString() {
        return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd
                + ", title=" + title + ", content=" + content + ", email="
                + email + ", hit=" + hit + ", regdate=" + regdate + ", useyn="
                + useyn + ", insertuid=" + insertuid + ", insertdt=" + insertdt
                + ", updateuid=" + updateuid + ", updatedt=" + updatedt + "]";
    }
    
    
    public ModelArticle() {
        super();
    }
    
    
}
