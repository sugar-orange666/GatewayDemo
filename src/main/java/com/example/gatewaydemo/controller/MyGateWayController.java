package com.example.gatewaydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date：2024/4/15 14:21
 * @Description
 */

@RestController
public class MyGateWayController {


    @RequestMapping("/one")
    public String one() {
        return "兜底数据";
    }
}
