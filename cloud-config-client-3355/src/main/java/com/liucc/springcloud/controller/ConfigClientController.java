package com.liucc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${file.name}")
    private String fileName;

    @GetMapping("/fileName")
    public String getFileName()
    {
        return fileName;
    }
}
