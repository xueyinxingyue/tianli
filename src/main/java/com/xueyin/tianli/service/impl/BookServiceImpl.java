package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.mapper.BookMapper;
import com.xueyin.tianli.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Override
    public List<Map<String, Object>> searchBooks(String keyword) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(keyword)){
            wrapper.like("book_name",keyword).or().like("writer",keyword);
        }
        List<Book> books = baseMapper.selectList(wrapper);
        List<Map<String,Object>> resultList = new ArrayList<>();
        for (Book book : books){
            Map<String,Object> map = new HashMap<>();
            map.put("bookId",book.getBookId());
            map.put("bookName",book.getBookName());
            map.put("writer",book.getWriter());
            map.put("bookImage",book.getBookImage());
            resultList.add(map);
        }
        return resultList;
    }
}
