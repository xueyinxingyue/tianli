package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Notification;
import com.xueyin.tianli.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private INotificationService notificationService;

    //通知添加
    @PostMapping("insert")
    public Result insert(@RequestBody Notification notification){
        notificationService.save(notification);
        return Result.success("成功添加");
    }

    //通知删除
    @DeleteMapping("delete")
    public Result delete(Integer id){
        notificationService.removeById(id);
        return Result.success("成功删除编号为： " + id + " 的通知");
    }

    //通知搜索
    @GetMapping("list")
    public Result list(String keyword){
        List<Map<String, Object>> notifications = notificationService.getNotifications(keyword);
        return Result.success(notifications);
    }

    //通知修改
    @PutMapping("update")
    public Result update(@RequestBody Notification notification){
        notificationService.updateById(notification);
        return Result.success("修改成功");
    }
}

