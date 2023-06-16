package com.xueyin.tianli.service;

import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.entity.Bookcategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
public interface IBookcategoryService extends IService<Bookcategory> {
    List<Map<String,Object>> listByCategoryIds(List<Integer> categoryIds);

    void insert(Bookcategory bookcategory);

}
