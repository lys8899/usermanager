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
public class Department extends EntityParent {


    @Column(name = "d_name")
    private String name;

    @Column(name = "d_parent_id")
    private Long parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
