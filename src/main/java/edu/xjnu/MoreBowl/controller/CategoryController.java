package edu.xjnu.MoreBowl.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.xjnu.MoreBowl.common.R;
import edu.xjnu.MoreBowl.entity.Category;
import edu.xjnu.MoreBowl.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 添加分类
     *
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info(category.toString());
        categoryService.save(category);
        return R.success("添加成功");
    }

    /**
     * 分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<IPage> page(Integer page, Integer pageSize) {
        // 分页构造器
        IPage<Category> pageInfo = new Page<>(page, pageSize);
        // 条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        // 添加排序条件, 根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);
        // 分页查询
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @DeleteMapping()
    // 前端传过来的是'ids', 不是'id'
    public R<String> delete(Long ids) {
        // boolean res = categoryService.removeById(ids);
        // if (res) {
        //     return R.success("删除成功");
        // }
        // else{
        //     return R.error("删除失败");
        // }

        categoryService.remove(ids);
        return R.success("删除成功");
    }

    @PutMapping()
    public R<String> update(@RequestBody Category category) {
        categoryService.updateById(category);
        return R.success("修改成功");
    }

    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }

}

