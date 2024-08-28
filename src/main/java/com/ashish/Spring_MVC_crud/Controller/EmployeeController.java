package com.ashish.Spring_MVC_crud.Controller;

import com.ashish.Spring_MVC_crud.Entity.employee;
import com.ashish.Spring_MVC_crud.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/display")
    public String getAll(Model model){
        List<employee> employees= employeeService.getAll();
        model.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model){
        //Create a model attribute to bind the form data
        employee emp=new employee();

        model.addAttribute("employee",emp);

        return "employees/showForm";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") employee theemployee){
        employeeService.save(theemployee);

        return "redirect:/employees/display";
    }

    @GetMapping("/showFormForUpdate")
    public String updateForm(@RequestParam("employeeId") int empid, Model model){
        Optional<employee> empbyId = employeeService.getById(empid);

        if(empbyId.isPresent()){
            model.addAttribute("employee", empbyId);
        }
        return "employees/showFormForUpdate";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId")int id, Model model){
        employeeService.delete(id);

        return "redirect:/employees/display";
    }
}
