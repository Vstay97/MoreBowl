package edu.xjnu.MoreBowl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.xjnu.MoreBowl.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Vstay
 * @date 2022/5/30 上午 2:46
 */

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
