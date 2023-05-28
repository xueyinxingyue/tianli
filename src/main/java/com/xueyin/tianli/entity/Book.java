package com.xueyin.tianli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends Bookcategories implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bookId", type = IdType.AUTO)
    private Integer bookId;

    @TableField(value = "bookName")
    private String bookName;

    private String writer;

    private String introduction;

    @TableField(value = "bookImage")
    private String bookImage;

    @TableField(value = "categoriesId")
    private Integer categoriesId;

    /**
     * 分类：0：both  1：男  2：女
     */
    private Integer gender;


}
