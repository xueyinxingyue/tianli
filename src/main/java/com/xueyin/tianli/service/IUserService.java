package com.xueyin.tianli.service;

import com.xueyin.tianli.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-26
 */
public interface IUserService extends IService<User> {
    //注册
    void create(User user);

    //登录
    User login(String username,String password);
}
