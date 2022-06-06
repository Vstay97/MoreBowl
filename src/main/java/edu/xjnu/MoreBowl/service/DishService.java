package edu.xjnu.MoreBowl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.xjnu.MoreBowl.dto.DishDto;
import edu.xjnu.MoreBowl.entity.Dish;
import org.springframework.stereotype.Service;

/**
 * @author Vstay
 * @date 2022/6/4 上午 4:44
 */

@Service
public interface DishService extends IService<Dish> {
    public void saveWithDishFlavor(DishDto dishDto);
}
