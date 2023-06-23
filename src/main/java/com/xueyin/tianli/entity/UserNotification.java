package com.xueyin.tianli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
