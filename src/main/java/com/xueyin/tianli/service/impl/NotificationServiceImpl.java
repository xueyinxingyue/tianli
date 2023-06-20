package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.Notification;
import com.xueyin.tianli.mapper.NotificationMapper;
import com.xueyin.tianli.service.INotificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyin
 * @since 2023-06-20
 */
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements INotificationService {

    @Override
    public List<Map<String, Object>> getNotifications(String keyword) {
        QueryWrapper<Notification> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)){
            wrapper.like("title",keyword).or().like("content",keyword);
        }
        wrapper.orderByDesc("create_time");
        List<Map<String, Object>> notifications = baseMapper.selectMaps(wrapper);
        return notifications;
    }
}
