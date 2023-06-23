package com.xueyin.tianli.mapper;

import com.xueyin.tianli.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xueyin
 * @since 2023-06-15
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
    @Select("SELECT p.post_id,p.title, p.content, p.time, u.name, u.avatar FROM post p JOIN user u ON p.author_id = u.user_id ORDER BY p.time DESC")
    List<Map<String, Object>> getPosts();

    @Select("SELECT p.post_id,p.title, p.content, p.time, u.name, u.avatar FROM post p JOIN user u ON p.author_id = u.user_id WHERE p.title LIKE CONCAT('%', #{keyword}, '%') OR p.content LIKE CONCAT('%', #{keyword}, '%') ORDER BY p.time DESC")
    List<Map<String, Object>> searchPosts(@Param("keyword") String keyword);
}
