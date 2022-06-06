package edu.xjnu.MoreBowl.controller;

import edu.xjnu.MoreBowl.common.R;
import edu.xjnu.MoreBowl.dto.DishDto;
import edu.xjnu.MoreBowl.entity.Dish;
import edu.xjnu.MoreBowl.entity.DishFlavor;
import edu.xjnu.MoreBowl.service.DishFlavorService;
import edu.xjnu.MoreBowl.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Vstay
 * @date 2022/6/5 下午 3:25
 */

@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private DishFlavorService dishFlavorService;

    @PostMapping()
    public R<String> save(@RequestBody DishDto dishDto) {
        dishService.saveWithDishFlavor(dishDto);
        return R.success("新增菜品成功");
    }


}
