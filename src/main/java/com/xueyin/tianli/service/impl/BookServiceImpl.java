package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.entity.BookBookcategory;
import com.xueyin.tianli.entity.Bookcategory;
import com.xueyin.tianli.mapper.BookMapper;
import com.xueyin.tianli.mapper.BookBookcategoryMapper;
import com.xueyin.tianli.mapper.BookcategoryMapper;
import com.xueyin.tianli.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookcategoryMapper bookcategoryMapper;
    @Autowired
    private BookBookcategoryMapper book_bookcategoryMapper;

    //条件搜索图书（若空则遍历全部）
    @Override
    public List<Map<String, Object>> searchBooks(String keyword) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)){
            wrapper.like("book_name",keyword).or().like("writer",keyword);
        }
        wrapper.select("book_id", "book_name", "writer", "book_image");
        List<Map<String, Object>> books = baseMapper.selectMaps(wrapper);
        return books;
    }

    //根据book_id查询到分类列表
    @Override
    public Book getById(Serializable bookId) {
        Book book = baseMapper.selectById(bookId);

        //根据id查询book_bookcategory表的bookcategory_id
        LambdaQueryWrapper<BookBookcategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(BookBookcategory::getBookId,bookId)
                .select(BookBookcategory::getBookcategoryId);

        //根据bookcategory_id查询bookcategory里的name
        LambdaQueryWrapper<Bookcategory> categorywrapper = new LambdaQueryWrapper<>();
        categorywrapper.in(Bookcategory::getBookcategoryId,book_bookcategoryMapper.selectObjs(wrapper));

        List<Bookcategory> bookCategories = bookcategoryMapper.selectList(categorywrapper);
        book.setBookcategoryList(bookCategories);
        return book;
    }
}
