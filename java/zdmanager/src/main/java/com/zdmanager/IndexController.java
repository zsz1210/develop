package com.zdmanager;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
@EnableAutoConfiguration
public class IndexController {

    @GetMapping("/") 
    public String index() {
        return "index";
    }
}
