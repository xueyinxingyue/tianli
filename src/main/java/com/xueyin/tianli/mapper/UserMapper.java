package com.xueyin.tianli.mapper;

import com.xueyin.tianli.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xueyin
 * @since 2023-05-26
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
