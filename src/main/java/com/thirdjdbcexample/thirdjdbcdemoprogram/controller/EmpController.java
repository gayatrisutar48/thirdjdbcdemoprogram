package com.thirdjdbcexample.thirdjdbcdemoprogram.controller;


import com.thirdjdbcexample.thirdjdbcdemoprogram.impl.EmpImpl;
import com.thirdjdbcexample.thirdjdbcdemoprogram.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmpController {

    @Autowired
    private EmpImpl empImpl;

    @GetMapping(value = "/getdata")
    public List<Employee> getData() {
        List<Employee> list = empImpl.GetEmployees();
        return list;

    }


    @GetMapping(value = "/getemp/{id}")
    public Employee getData1(@PathVariable Integer id) {
        Employee emp = empImpl.getEmployee(id);
        return emp;
    }

    @GetMapping(value = "/delemp/{id}")
    public String getData2(@PathVariable Integer id) {
        String emp = empImpl.deleteEmployee(id);
        return emp;

    }

    @PostMapping(value = "/savedata")
    public String savedata(@RequestBody Employee employee) {
        String result = empImpl.saveEmployee(employee);
        return result;
    }

    @GetMapping(value = "/update/{id}/{name}")
    public String updatedata(@PathVariable Integer id, @PathVariable String name) {
        String res = empImpl.updateEmployee(id, name);
        return res;
    }

    @GetMapping(value = "/joindata")
    public List<Map<String, Object>> getCombineddata() {
        return empImpl.getCombinedData();
    }
}