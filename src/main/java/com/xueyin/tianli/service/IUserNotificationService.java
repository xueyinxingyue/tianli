package com.xueyin.tianli.service;

import com.xueyin.tianli.entity.UserNotification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyin
 * @since 2023-06-20
 */
public interface IUserNotificationService extends IService<UserNotification> {

    void sendUsers(Integer notificationId, Integer userId);

    List<Map<String,Object>> getByUserId(Integer userId);
}
