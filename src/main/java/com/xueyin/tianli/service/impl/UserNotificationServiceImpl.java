package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xueyin.tianli.entity.User;
import com.xueyin.tianli.entity.UserNotification;
import com.xueyin.tianli.mapper.UserMapper;
import com.xueyin.tianli.mapper.UserNotificationMapper;
import com.xueyin.tianli.service.IUserNotificationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xueyin.tianli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserNotificationServiceImpl extends ServiceImpl<UserNotificationMapper, UserNotification> implements IUserNotificationService {
    @Autowired
    private IUserNotificationService userNotificationService;
    @Autowired
    private UserNotificationMapper userNotificationMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void sendUsers(Integer notificationId, Integer userId) {
        if (userId != null) {
            UserNotification userNotification = new UserNotification();
            userNotification.setNotificationId(notificationId);
            userNotification.setUserId(userId);

            userNotificationService.save(userNotification);
        } else {
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            List<User> userList = userMapper.selectList(wrapper);  // 获取所有用户列表

            for (User user : userList) {
                UserNotification userNotification = new UserNotification();
                userNotification.setUserId(user.getUserId());
                userNotification.setNotificationId(notificationId);

                userNotificationService.save(userNotification);
            }
        }
    }

    @Override
    public List<Map<String, Object>> getByUserId(Integer userId) {
        return userNotificationMapper.getNotificationsByUserId(userId);
    }
}
