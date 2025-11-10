package kr.java.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public String getProductInfo() {
        return "정보";
    }

    public String getProductInfo2(String s) {
        return "정보 : " + s;
    }
}
