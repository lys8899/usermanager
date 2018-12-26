package com.lys.usermanager.entity;

import com.lys.usermanager.until.EntityParent;

import javax.persistence.*;
import java.util.Set;

/**
 * @description: 角色
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 12:42
 **/
@Entity
@Table(name = "sys_role")
public class Role extends EntityParent {

    @Column(name = "r_name", length = 60)
    private String name;

    @Column(name = "r_describe")
    private String describ;

    @ManyToMany
    @JoinTable(name = "sys_row_function",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "function_id", referencedColumnName = "id")})
    private Set<Function> functions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

}
