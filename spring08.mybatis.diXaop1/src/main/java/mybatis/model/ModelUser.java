package mybatis.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelUser {
    // SLF4J Logging
    private static Logger logger = LoggerFactory.getLogger(ModelUser.class);
    
    
    Integer userno     ;
    String userid      ;
    String email       ;
    String passwd      ;
    String name        ;
    String mobile      ;
    Boolean retireyn   ;
    String insertuid   ;
    Date insertdt      ;
    String updateuid   ;
    String updateupw   ;
    Date updatedt      ;
    
    
    
    
    public Integer getUserno() {
        return userno;
    }
    public void setUserno(Integer userno) {
        this.userno = userno;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Boolean getRetireyn() {
        return retireyn;
    }
    public void setRetireyn(Boolean retireyn) {
        this.retireyn = retireyn;
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
    
    public ModelUser() {
        super();
    }
    
    public String getUpdateupw() {
        return updateupw;
    }
    public void setUpdateupw(String updateupw) {
        this.updateupw = updateupw;
    }
    public ModelUser(Integer userno, String userid, String email, String passwd,
            String name, String mobile, Boolean retireyn, String insertuid,
            Date insertdt, String updateuid, String updateupw, Date updatedt) {
        super();
        this.userno = userno;
        this.userid = userid;
        this.email = email;
        this.passwd = passwd;
        this.name = name;
        this.mobile = mobile;
        this.retireyn = retireyn;
        this.insertuid = insertuid;
        this.insertdt = insertdt;
        this.updateuid = updateuid;
        this.updateupw = updateupw;
        this.updatedt = updatedt;
    }
    @Override
    public String toString() {
        return "ModelUser [userno=" + userno + ", userid=" + userid + ", email="
                + email + ", passwd=" + passwd + ", name=" + name + ", mobile="
                + mobile + ", retireyn=" + retireyn + ", insertuid=" + insertuid
                + ", insertdt=" + insertdt + ", updateuid=" + updateuid
                + ", updateupw=" + updateupw + ", updatedt=" + updatedt + "]";
    }
    
    
    
}
