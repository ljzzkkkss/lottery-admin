package com.ljzzkkkss.lottery.admin.controller;

import com.ljzzkkkss.lottery.admin.constants.ReturnType;
import com.ljzzkkkss.lottery.admin.model.ReturnBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class FileController {
    @Value("${file.path}")
    private String path;

    @PostMapping("/file/upload")
    public ReturnBody upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(-1 == file.getOriginalFilename().lastIndexOf('.')){
            return ReturnType.INVALID_FILE;
        }
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dayFormat.format(new Date());
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
        String filePath = path + date + "/";
        String fileName = System.currentTimeMillis() + suffix;
        File storeFile = new File( filePath + fileName);
        if(!storeFile.getParentFile().exists()){
            storeFile.getParentFile().mkdirs();
        }
        storeFile.createNewFile();
        try (FileOutputStream out = new FileOutputStream(storeFile)) {
            out.write(file.getBytes());
        }
        return new ReturnBody(filePath + fileName);
    }
}
