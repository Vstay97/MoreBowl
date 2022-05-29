package edu.xjnu.MoreBowl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.xjnu.MoreBowl.entity.Employee;
import edu.xjnu.MoreBowl.mapper.EmployeeMapper;
import edu.xjnu.MoreBowl.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author Vstay
 * @date 2022/5/30 上午 2:49
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
