package edu.xjnu.MoreBowl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.xjnu.MoreBowl.entity.Category;
import edu.xjnu.MoreBowl.mapper.CategoryMapper;
import edu.xjnu.MoreBowl.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @author Vstay
 * @date 2022/6/4 上午 1:12
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
