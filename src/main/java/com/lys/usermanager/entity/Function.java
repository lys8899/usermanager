package com.lys.usermanager.entity;

import com.lys.usermanager.until.EntityParent;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @description: 权限
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 12:44
 **/
@Entity
@Table(name = "sys_function")
public class Function extends EntityParent implements GrantedAuthority {


    @Column(name = "f_name")
    private String name;

    @Column(name = "f_mark")
    private String mark;

    @Column(name = "f_systemid")
    private Integer systemId;

    @Column(name = "f_is_close")
    private Boolean close;

    @Column(name = "f_parentid")
    private Integer parenId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }

    public Integer getParenId() {
        return parenId;
    }

    public void setParenId(Integer parenId) {
        this.parenId = parenId;
    }

    @Override
    public String getAuthority() {
        return mark;
    }
}
