package com.ashish.Spring_MVC_crud.Service;

import com.ashish.Spring_MVC_crud.Entity.employee;
import com.ashish.Spring_MVC_crud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<employee> getAll(){
        return employeeRepository.findAllByOrder();
    }

    public String save(employee theemp){
         employeeRepository.save(theemp);
        return "Saved successfully";
    }

    public Optional<employee> getById(int id){
        return employeeRepository.findById(id);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

}
