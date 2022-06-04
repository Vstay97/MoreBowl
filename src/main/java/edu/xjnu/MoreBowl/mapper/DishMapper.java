package edu.xjnu.MoreBowl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.xjnu.MoreBowl.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Vstay
 * @date 2022/6/4 上午 4:44
 */

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
