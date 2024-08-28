package com.ashish.Spring_MVC_crud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class ManagerController {

    @GetMapping("/manager")
    public String manager(){
        return "employees/manager";
    }

    @GetMapping("/admin")
    public String admin(){
        return "employees/admin";
    }
}
