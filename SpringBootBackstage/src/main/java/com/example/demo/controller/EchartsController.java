package com.example.demo.controller;

import com.example.demo.domain.EchartsPOJO;
import com.example.demo.service.ITimeFlow;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: linjie
 * @Description: 请求处理控制器
 * @Date: 下午 17:06 2018/7/21 0021
 */
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class EchartsController {
    @Resource
    private ITimeFlow iTimeFlow;

    @GetMapping("/timeflow")
    public Map timeflow(){
        return iTimeFlow.GetTimeFlow();
    }
}
