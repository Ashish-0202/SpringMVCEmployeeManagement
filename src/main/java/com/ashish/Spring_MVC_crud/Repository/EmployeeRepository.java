package com.ashish.Spring_MVC_crud.Repository;

import com.ashish.Spring_MVC_crud.Entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Integer> {

    //Method to sort by last name
    @Query(value = "SELECT * FROM employee order by employee_name asc", nativeQuery = true)
    public List<employee> findAllByOrder();

}
