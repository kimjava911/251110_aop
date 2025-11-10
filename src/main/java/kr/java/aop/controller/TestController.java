package kr.java.aop.controller;

import kr.java.aop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
//    @GetMapping("/test")
    @RequestMapping("/test")
    public String text() {
        return "index";
    }
}
