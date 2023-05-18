package com.lcwd.SpringTODO.todomanager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);
    @PostMapping("/single")
    public String fileHandling(@RequestParam("img")MultipartFile image)
    {
        logger.info(image.getContentType());
        logger.info(image.getOriginalFilename());
        long size = image.getSize();
        System.out.println(size);
        return "successs...";
    }
}
