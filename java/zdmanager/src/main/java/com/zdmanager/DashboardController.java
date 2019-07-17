package com.zdmanager;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@EnableAutoConfiguration
public class DashboardController {

    @RequestMapping("/") 
    public String index() {
        return "dashboard/index";
    }
}
