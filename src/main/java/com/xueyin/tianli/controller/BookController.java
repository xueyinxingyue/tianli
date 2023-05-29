package com.xueyin.tianli.controller;



import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return Result.success("加载成功", searchBooks);
    }
}

