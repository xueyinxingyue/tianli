package com.xueyin.tianli.mapper;

import com.xueyin.tianli.entity.Bookcategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xueyin
 * @since 2023-05-28
 */
@Repository
public interface BookcategoryMapper extends BaseMapper<Bookcategory> {
}
