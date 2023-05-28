package com.xueyin.tianli.service.impl;

import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.mapper.BookMapper;
import com.xueyin.tianli.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
