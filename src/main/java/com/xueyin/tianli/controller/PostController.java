package com.xueyin.tianli.controller;


import com.xueyin.tianli.common.Result;
import com.xueyin.tianli.entity.Post;
import com.xueyin.tianli.service.IPostService;
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
 * @since 2023-06-15
 */
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    //帖子添加      author_id传入当前user_id的值
    @PostMapping("insert")
    public Result insert(@RequestBody Post post){
        postService.save(post);
        return Result.success("帖子发送成功");
    }

    //帖子删除
    @DeleteMapping("delete")
    public Result delete(Integer id){
        postService.removeById(id);
        return Result.success("帖子删除成功");
    }

    //帖子遍历
    @GetMapping("list")
    public Result list(){
        List<Map<String, Object>> posts = postService.getPosts();
        return Result.success(posts);
    }

    //帖子详细页
    @GetMapping("get")
    public Result get(Integer postId){
        Post post = postService.getById(postId);
        return Result.success(post);
    }

    //帖子搜索
    @GetMapping("searchPosts")
    public Result searchPosts(@RequestParam("keyword") String keyword){
        List<Map<String, Object>> searchPosts = postService.searchPosts(keyword);
        return Result.success(searchPosts);
    }

    //帖子修改
    @PutMapping("update")
    public Result update(@RequestBody Post post){
        postService.updateById(post);
        return Result.success("帖子修改成功");
    }
}

