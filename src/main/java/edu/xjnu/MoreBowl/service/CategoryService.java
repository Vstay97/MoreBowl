package edu.xjnu.MoreBowl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.xjnu.MoreBowl.entity.Category;

/**
 * @author Vstay
 * @date 2022/6/4 上午 1:10
 */

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
