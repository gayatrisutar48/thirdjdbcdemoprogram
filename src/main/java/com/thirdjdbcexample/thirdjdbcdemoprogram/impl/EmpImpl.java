package com.thirdjdbcexample.thirdjdbcdemoprogram.impl;


import com.thirdjdbcexample.thirdjdbcdemoprogram.repository.EmpRepo;
import com.thirdjdbcexample.thirdjdbcdemoprogram.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmpImpl implements EmpRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Employee emptable;


    @Override
    public List<Employee> GetEmployees() {
        String sql = "select * from emptable";
        List<Employee> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployee(Integer id) {
        String sql = "select * from emptable where id=?";
        Employee emp = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Employee.class));

        return emp;
    }

    @Override
    public String deleteEmployee(Integer id) {
        String sql = "delete from emptable where id=?";
        jdbcTemplate.update(sql, new Object[]{id});
//queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper(Employee.class));

        return "data deleted";
    }


    @Override
    public String saveEmployee(Employee employee) {
        String sql = "insert into emptable(id,name,city) values(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{employee.getId(), employee.getName(), employee.getCity()});
        return "data saved";
    }

    @Override
    public String updateEmployee(Integer id, String name) {
        String sql = "update emptable set name=? where id=?";
        jdbcTemplate.update(sql, new Object[]{name, id});
        return "Data updated";

    }

    @Override
    public List<Map<String, Object>> getCombinedData() {

        String sql = "select d.deptname, e.name, e.city from emptable e,department d " + "where e.id=d.deptid";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;

    }


}
