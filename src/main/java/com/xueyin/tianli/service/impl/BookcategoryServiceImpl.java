package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.entity.Bookcategory;
import com.xueyin.tianli.mapper.BookMapper;
import com.xueyin.tianli.mapper.BookcategoryMapper;
import com.xueyin.tianli.service.IBookcategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@Service
public class BookcategoryServiceImpl extends ServiceImpl<BookcategoryMapper, Bookcategory> implements IBookcategoryService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BookcategoryMapper bookcategoryMapper;

    @Override
    public List<Book> listByCategoryIds(List<Integer> categoryIds) {
        String categoryIdStr = categoryIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        return bookMapper.selectList(new QueryWrapper<Book>()
                        .inSql("book_id", "SELECT book_id FROM book_category WHERE category_id IN (" + categoryIdStr + ")"));
//        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.inSql("book_id","select book_id from bookcategory where category_id in (" + categoryIdStr + ")");

//        return baseMapper.selectList(wrapper);
    }
}
