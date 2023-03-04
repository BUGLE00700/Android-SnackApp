package com.gec.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.entity.User;
import com.gec.mapper.UserMapper;
import com.gec.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册方法实现
     *
     * @param user
     * @return
     */
    @Override
    public int register(User user) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("loginname", user.getLoginname());
        User userDB = this.userMapper.selectOne(wrapper);

        //判断数据库是否存在该用户
        if (!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户已存在");
        //判断密码是否填写
        if (user.getPassword().equals("") || user.getPassword() == null) throw new RuntimeException("密码为空");

        //给密码加密
        String newPassword = DigestUtil.md5Hex(user.getPassword());
        //设置
        user.setPassword(newPassword);

        return this.userMapper.insert(user);


    }

    /**
     * 登录方法实现
     * @param user
     * @return
     */
    @Override
    public User login(User user) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("loginname", user.getLoginname());
        User userDB = this.userMapper.selectOne(wrapper);

        if (ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户不存在");

        String md5Hex = DigestUtil.md5Hex(user.getPassword());

        if (!md5Hex.equals(userDB.getPassword())) throw new RuntimeException("密码错误");

        return userDB;


    }
}
