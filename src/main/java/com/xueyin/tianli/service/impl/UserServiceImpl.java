package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.User;
import com.xueyin.tianli.mapper.UserMapper;
import com.xueyin.tianli.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    //注册业务逻辑
    @Override
    public void create(User user) throws IllegalArgumentException, DataAccessException {
        String username = user.getUsername();
        String password = user.getPassword();

        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new IllegalArgumentException("输入的用户名或密码不能为空");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User checkUser = userMapper.selectOne(queryWrapper);
        if (checkUser != null){
            throw new IllegalArgumentException("用户名已被注册");
        }else {
            userMapper.insert(user);
        }
    }

    //登录业务逻辑
    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()){
            throw new IllegalArgumentException("用户名或密码不能为空");
        }
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User user = userMapper.selectOne(queryWrapper);
        if (user == null){
            throw new IllegalArgumentException("用户不存在，请检查后重试");
        }else if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("密码不正确，请检查后重试");
        }
        return user;
    }

}