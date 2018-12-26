package com.lys.usermanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 首页
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2018-09-08 16:43
 **/
@RestController("/page")
public class PageController {

    /**
     * @Description 跳转主页
     * @date 2017/12/20 10:2
     */
    @GetMapping("/index")
    public String goToIndex() {
        return "index";
    }
}
