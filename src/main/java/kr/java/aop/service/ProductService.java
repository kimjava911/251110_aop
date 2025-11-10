package kr.java.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public String getProductInfo() {
        this.secret(); // private은 감지를 못함
        return "정보";
    }

    public String getProductInfo2(String s) {
        this.secret(); // private은 감지를 못함
        return "정보 : " + s;
    }

    private void secret() {
        System.out.println("***자체 호출 메서드!***");
    }

    public String error() {
        throw new RuntimeException();
    }
}
