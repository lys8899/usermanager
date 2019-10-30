package com.lys.usermanager.entity;


import com.lys.usermanager.until.EntityParent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 部门
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 14:47
 **/
@Entity
@Table(name = "sys_department")
public class SysDepartment extends EntityParent {

    private String fName;
    private Long fParentId;
    private String fType;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Long getfParentId() {
        return fParentId;
    }

    public void setfParentId(Long fParentId) {
        this.fParentId = fParentId;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }
}
