package edu.xjnu.MoreBowl.controller;

import edu.xjnu.MoreBowl.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Vstay
 * @date 2022/6/5 上午 12:38
 */

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${moreBowl.path}")
    private String BasePath;


    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        // file是一个临时文件, 需要转存到指定的位置, 否则会被丢弃
        log.info(file.toString());

        // 获得文件后缀
        String prefix = file.getOriginalFilename().toString().substring(file.getOriginalFilename().toString().lastIndexOf("."));
        // 生成新的文件名
        String fileName = UUID.randomUUID().toString() + prefix;
        // 检查路径
        File dir = new File(BasePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 转存文件
        try {
            file.transferTo(new File(BasePath+ fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return R.success(fileName);
    }
}
