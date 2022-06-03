package edu.xjnu.MoreBowl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.xjnu.MoreBowl.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Vstay
 * @date 2022/6/4 上午 1:09
 */

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
