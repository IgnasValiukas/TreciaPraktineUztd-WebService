package viko.eif.ivaliukas.lego.rest.service;

import viko.eif.ivaliukas.lego.rest.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> allEmployee();
    Employee addEmployee(Employee employee);

}
