package com.xueyin.tianli.controller;



import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    //图书搜索
    @GetMapping("searchBooks")
    public Result searchBooks(String keyword) {
        List<Map<String, Object>> searchBooks = bookService.searchBooks(keyword);
        return Result.success("获取成功", searchBooks);
    }

    //根据id获取图书详细信息
    @GetMapping("bookInfo")
    public Result bookInfo(@RequestParam Integer bookId) {
        Book book = bookService.getById(bookId);
        return Result.success("获取成功", book);
    }
}

