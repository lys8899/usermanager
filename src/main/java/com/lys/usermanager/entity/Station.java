package com.lys.usermanager.entity;

import com.lys.usermanager.until.EntityParent;

import javax.persistence.*;

/**
 * @description: 单位
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 14:47
 **/
@Table(name = "sys_station")
@Entity
public class Station extends EntityParent {

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_parent_id")
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
