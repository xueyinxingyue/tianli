package com.xueyin.tianli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Bookcategories implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "categoriesId", type = IdType.AUTO)
    private Integer categoriesId;

    @TableField(value = "categoriesName")
    private String categoriesName;


}
