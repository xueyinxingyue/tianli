package com.xueyin.tianli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xueyin.tianli.entity.Post;
import com.xueyin.tianli.entity.User;
import com.xueyin.tianli.mapper.PostMapper;
import com.xueyin.tianli.mapper.UserMapper;
import com.xueyin.tianli.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2023-06-15
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<Map<String, Object>> getPosts() {
        return postMapper.getPosts();
    }

    @Override
    public List<Map<String, Object>> searchPosts(String keyword) {
        return postMapper.searchPosts(keyword);
    }

}
