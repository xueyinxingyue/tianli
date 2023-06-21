package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.UserNotification;
import com.xueyin.tianli.service.IUserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xueyin
 * @since 2023-06-20
 */
@RestController
@RequestMapping("/userNotification")
public class UserNotificationController {
    @Autowired
    private IUserNotificationService userNotificationService;

    //输入通知id，发送给某个用户，若userId为空则发送给所有用户
    @PostMapping("sendUsers")
    public Result sendUsers(Integer notificationId, Integer userId) {
        userNotificationService.sendUsers(notificationId, userId);
        return Result.success("发送成功");
    }

    //根据通知id，删除某条已发送的通知
    @DeleteMapping("delete")
    public Result delete(Integer id){
        Map<String, Object> notificationId = new HashMap<>();
        notificationId.put("notification_id",id);

        userNotificationService.removeByMap(notificationId);
        return Result.success("删除成功，共" + notificationId.size() + "条通知");
    }

    //根据用户id，查询用户通知
    @GetMapping("get")
    public Result get(Integer userId){
        List<Map<String, Object>> notifications = userNotificationService.getByUserId(userId);
        return Result.success("查询成功：",notifications);
    }

    //查询用户通知表
    @GetMapping("list")
    public Result list(){
        List<UserNotification> userNotificationList = userNotificationService.list();
        return Result.success("查询全部信息",userNotificationList);
    }
}

