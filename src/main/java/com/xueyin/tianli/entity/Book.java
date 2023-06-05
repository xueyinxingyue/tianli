package com.xueyin.tianli.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
public class Book extends Bookcategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer bookId;

    private String bookName;

    private String writer;

    private String introduction;

    private String bookImage;

    /**
     * 分类：0：both  1：男  2：女
     */
    private Integer gender;

    @TableField(exist = false)
    private Integer bookcategoryId;

    @TableField(exist = false)
    private String bookcategoryName;

    //分类
    @TableField(exist = false)
    private List<Bookcategory> bookcategoryList;
}
