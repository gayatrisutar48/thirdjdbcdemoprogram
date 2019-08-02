package com.thirdjdbcexample.thirdjdbcdemoprogram.repository;

import com.thirdjdbcexample.thirdjdbcdemoprogram.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmpRepo {

List<Employee>GetEmployees();

Employee getEmployee(Integer id);

String deleteEmployee(Integer id);

String saveEmployee(Employee employee);

String updateEmployee(Integer id,String name);

List<Map<String, Object>> getCombinedData();

}
