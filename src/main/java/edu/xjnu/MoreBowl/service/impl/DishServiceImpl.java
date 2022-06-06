package edu.xjnu.MoreBowl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.xjnu.MoreBowl.dto.DishDto;
import edu.xjnu.MoreBowl.entity.Dish;
import edu.xjnu.MoreBowl.entity.DishFlavor;
import edu.xjnu.MoreBowl.mapper.DishMapper;
import edu.xjnu.MoreBowl.service.DishFlavorService;
import edu.xjnu.MoreBowl.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Vstay
 * @date 2022/6/4 上午 4:45
 */

@Slf4j
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

    @Autowired
    DishFlavorService dishFlavorService;

    @Override
    public void saveWithDishFlavor(DishDto dishDto) {
        // 保存菜品的基本信息表到菜品表dish
        this.save(dishDto);
        // 获得菜品id
        Long id = dishDto.getId();
        // 菜品口味
        List<DishFlavor> flavors = dishDto.getFlavors();
        for (DishFlavor flavor : flavors) {
            flavor.setDishId(id);
        }
        // 保存菜品口味到菜品口味表dish_flavor
        dishFlavorService.saveBatch(flavors);
    }
}
