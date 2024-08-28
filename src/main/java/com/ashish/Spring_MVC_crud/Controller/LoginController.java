package com.ashish.Spring_MVC_crud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String login(){
        return "employees/login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "employees/accessDenied";
    }
}
