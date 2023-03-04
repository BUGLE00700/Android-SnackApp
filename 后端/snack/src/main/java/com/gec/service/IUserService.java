package com.gec.service;

import com.gec.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IUserService extends IService<User> {

    /**
     * 注册方法
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

}
