package com.xueyin.tianli.service;

import com.xueyin.tianli.entity.Notification;
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
public interface INotificationService extends IService<Notification> {
    List<Map<String, Object>> getNotifications(String keyword);
}
