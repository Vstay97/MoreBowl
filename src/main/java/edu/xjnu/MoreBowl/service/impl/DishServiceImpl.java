package edu.xjnu.MoreBowl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.xjnu.MoreBowl.entity.Dish;
import edu.xjnu.MoreBowl.mapper.DishMapper;
import edu.xjnu.MoreBowl.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @author Vstay
 * @date 2022/6/4 上午 4:45
 */

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
