package com.lys.usermanager.mqconsumer;

import com.lys.usermanager.config.RabbitmqConfig;
import com.lys.usermanager.entity.SysUser;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * @description: 用户新增消息
 * @author: LiYongSen[825760990@qq.com]
 * @create: 2019-10-29 15:28
 **/
@Component
public class UserConsumer {

    private CacheManager cacheManager;


    @RabbitListener(queues = RabbitmqConfig.Q_CLEAR_CACHE)
    public void handleClearCache(SysUser user) {
        System.out.println("------------" + RabbitmqConfig.Q_CLEAR_CACHE + "------------");
        System.out.println(user);
    }

    @RabbitListener(queues = RabbitmqConfig.Q_SEND_EMAIL)
    public void handleChangePassword(SysUser user) {
        System.out.println("------------" + RabbitmqConfig.Q_SEND_EMAIL + "------------");
        System.out.println(user);
    }


    @RabbitListener(queues = RabbitmqConfig.Q_USER_LOGOUT)
    public void handleDelete(SysUser message) {
        System.out.println("------------" + RabbitmqConfig.Q_USER_LOGOUT + "------------");
        System.out.println(message);
    }


}
