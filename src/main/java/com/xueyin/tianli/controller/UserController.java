package com.xueyin.tianli.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.User;
import com.xueyin.tianli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xueyin
 * @since 2023-05-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //code 200      message:操作成功    data：{}

    //用户注册
    @GetMapping("create")
    public Result create(User user){
        userService.create(user);
        return Result.success("注册成功");
    }

    //根据username和password登录
    @GetMapping("login")
    public ResponseEntity<User> login(String username,String password) {
        User user = userService.login(username, password);
        if (user != null) {
            // 如果验证成功，则返回用户信息
            return ResponseEntity.ok(user);
        } else {
            // 如果验证失败，则返回相应的信息
            return ResponseEntity.badRequest().body(null);
        }
    }

    //根据id获取用户信息
    @GetMapping("get")
    public Result get(Long userId){
        User user = userService.getById(userId);
        return Result.success("加载成功",user);
    }

    //修改用户信息
    @PutMapping("update")
    public Result update(User user){
        userService.updateById(user);
        return Result.success("保存成功");
    }
}

