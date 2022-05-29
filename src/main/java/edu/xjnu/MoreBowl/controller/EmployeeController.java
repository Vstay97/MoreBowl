package edu.xjnu.MoreBowl.controller;

import edu.xjnu.MoreBowl.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vstay
 * @date 2022/5/30 上午 2:52
 */

@Slf4j
@RestController()
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
}
