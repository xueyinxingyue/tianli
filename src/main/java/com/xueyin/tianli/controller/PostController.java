package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.service.IPostService;
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
 * @since 2023-06-15
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    //帖子遍历
    @GetMapping("getPosts")
    public List<Map<String, Object>> getPosts() {
        return postService.getPosts();
    }

    //帖子搜索
    @GetMapping("searchPosts")
    public List<Map<String, Object>> searchPosts(@RequestParam("keyword") String keyword) {
        return postService.searchPosts(keyword);
    }
}

