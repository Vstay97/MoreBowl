package edu.xjnu.MoreBowl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.xjnu.MoreBowl.common.CustomException;
import edu.xjnu.MoreBowl.entity.Category;
import edu.xjnu.MoreBowl.entity.Dish;
import edu.xjnu.MoreBowl.entity.Setmeal;
import edu.xjnu.MoreBowl.mapper.CategoryMapper;
import edu.xjnu.MoreBowl.service.CategoryService;
import edu.xjnu.MoreBowl.service.DishService;
import edu.xjnu.MoreBowl.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vstay
 * @date 2022/6/4 上午 1:12
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    DishService dishService;

    @Autowired
    SetmealService setmealService;


    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        dishQueryWrapper.eq(Dish::getCategoryId, id);
        int count = dishService.count(dishQueryWrapper);
        if (count > 0) {
            throw new CustomException("该分类下有菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        setmealQueryWrapper.eq(Setmeal::getCategoryId, id);
        count = setmealService.count(setmealQueryWrapper);
        if (count > 0) {
            throw new CustomException("该分类下有套餐，不能删除");
        }

        super.removeById(id);

    }
}
