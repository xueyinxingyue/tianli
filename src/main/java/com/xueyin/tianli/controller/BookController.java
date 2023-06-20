package com.xueyin.tianli.controller;



import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Book;
import com.xueyin.tianli.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //图书添加
    @PostMapping("insert")
    public Result insert(@RequestBody Book book){
        bookService.save(book);
        return Result.success("成功添加");
    }

    //图书删除
    @DeleteMapping("delete")
    public Result delete(Integer id){
        bookService.removeById(id);
        return Result.success("成功删除");
    }

    //图书信息修改
    @PutMapping("update")
    public Result update(@RequestBody Book book){
        bookService.updateById(book);
        return Result.success("修改成功");
    }
}

