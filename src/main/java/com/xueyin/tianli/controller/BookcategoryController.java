package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Bookcategory;
import com.xueyin.tianli.mapper.BookcategoryMapper;
import com.xueyin.tianli.service.IBookcategoryService;
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
@RequestMapping("/bookcategory")
public class BookcategoryController {
    @Autowired
    private IBookcategoryService bookcategoryService;

    //遍历分类
    @GetMapping("listAll")
    public Result listAll(){
        List<Bookcategory> categoryList = bookcategoryService.list();
        return Result.success("所有分类信息查询成功",categoryList);
    }

    //根据多个分类筛选图书
    @GetMapping("listByCategoryIds")
    public Result listByCategoryIds(@RequestParam List<Integer> categoryIds){
        List<Map<String,Object>> books = bookcategoryService.listByCategoryIds(categoryIds);
        return Result.success(books);
    }

    //添加分类
    @PostMapping("insert")
    public Result insert(Bookcategory bookcategory) {
        bookcategoryService.insert(bookcategory);
        return Result.success("添加成功");
    }

    //删除分类
    @DeleteMapping("delete")
    public Result delete(Integer id){
        bookcategoryService.removeById(id);
        return Result.success("分类删除成功");
    }

    //修改分类
    @PutMapping("update")
    public Result update(Bookcategory bookcategory){
        bookcategoryService.updateById(bookcategory);
        return Result.success("分类修改成功");
    }
}

