package com.xueyin.tianli.service;

import com.xueyin.tianli.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xueyin
 * @since 2023-06-15
 */
public interface IPostService extends IService<Post> {
    List<Map<String, Object>> getPosts();

    List<Map<String, Object>> searchPosts(String keyword);
}
