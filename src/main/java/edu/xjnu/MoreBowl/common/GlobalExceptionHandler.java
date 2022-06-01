package edu.xjnu.MoreBowl.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author Vstay
 * @date 2022/6/1 下午 7:21
 */

@ResponseBody
@Slf4j
@ControllerAdvice(annotations = {ResponseBody.class, Controller.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> GlobalExceptionHandler(SQLIntegrityConstraintViolationException ex) {
        // log.error("SQLIntegrityConstraintViolationException", ex.getMessage());
        String mes = ex.getMessage();
        if (mes.contains("Duplicate entry")) {
            String msg = mes.split(" ")[2]+ " 已存在";
            return R.error(msg);
        }
        return R.error("操作失败");
    }
}
