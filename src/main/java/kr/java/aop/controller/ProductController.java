package kr.java.aop.controller;

import kr.java.aop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model) {
//        System.out.println("index");
        String info = productService.getProductInfo();
        String info2 = productService.getProductInfo2("test");
        model.addAttribute(model);
        return "index";
    }

    @GetMapping("/product")
//    public String product() {
    public String productPage() {
//        System.out.println("product");
        productService.error(); // view를 리턴하지 못함
        return "product";
    }
}
