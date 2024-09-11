package com.tequila.ecommerce.vinoteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/about.html";
    }

    @GetMapping("/product")
    public String product() {
        return "forward:/product.html";
    }

    @GetMapping("/product-single")
    public String productSingle() {
        return "forward:/product-single.html";
    }

    @GetMapping("/cart")
    public String cart() {
        return "forward:/cart.html";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "forward:/checkout.html";
    }

    @GetMapping("/blog")
    public String blog() {
        return "forward:/blog.html";
    }

    @GetMapping("/blog-single")
    public String blogSingle() {
        return "forward:/blog-single.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "forward:/contact.html";
    }

    @GetMapping("/main")
    public String main() {
        return "forward:/main.html";
    }
}