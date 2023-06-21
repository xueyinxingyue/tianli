package com.xueyin.tianli.mapper;

import com.xueyin.tianli.entity.UserNotification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xueyin
 * @since 2023-06-20
 */
@Mapper
public interface UserNotificationMapper extends BaseMapper<UserNotification> {
    @Select("SELECT n.title, n.content,un.is_read,un.create_time FROM user_notification un JOIN notification n ON un.notification_id = n.notification_id WHERE un.user_id = #{userId} order by un.create_time desc;")
    List<Map<String, Object>> getNotificationsByUserId(@Param("userId") Integer userId);
}
