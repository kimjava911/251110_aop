package kr.java.aop.controller;

import kr.java.aop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
//        System.out.println("index");
        return "index";
    }

    @GetMapping("/product")
//    public String product() {
    public String productPage() {
//        System.out.println("product");
        return "product";
    }
}
