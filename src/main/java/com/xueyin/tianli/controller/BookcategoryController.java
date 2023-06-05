package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Bookcategory;
import com.xueyin.tianli.service.IBookcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //根据分类id筛选图书
//    @GetMapping("listByCategoryId")
//    public Result listByCategoryId(){
//
//    }
}

