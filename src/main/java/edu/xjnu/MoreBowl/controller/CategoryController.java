package edu.xjnu.MoreBowl.controller;

import edu.xjnu.MoreBowl.common.R;
import edu.xjnu.MoreBowl.entity.Category;
import edu.xjnu.MoreBowl.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vstay
 * @date 2022/6/4 上午 1:16
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info(category.toString());
        categoryService.save(category);
        return  R.success("添加成功");
    }
}

