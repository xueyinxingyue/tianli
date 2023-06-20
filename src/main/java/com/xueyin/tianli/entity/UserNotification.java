package com.xueyin.tianli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xueyin
 * @since 2023-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserNotification implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_notification_id", type = IdType.AUTO)
    private Integer userNotificationId;

    private Integer userId;

    private Integer notificationId;

    private Boolean isRead;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
