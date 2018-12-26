package com.lys.usermanager.until;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @description: 实体类必备属性
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 12:21
 **/
@MappedSuperclass
public class EntityParent {

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private String id;


    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtCreate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date gmtModified;

    @Version
    private Long version;


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
