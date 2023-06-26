package viko.eif.ivaliukas.lego.rest.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import viko.eif.ivaliukas.lego.rest.model.Employee;
import viko.eif.ivaliukas.lego.rest.repository.EmployeeRepository;
import viko.eif.ivaliukas.lego.rest.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> allEmployee(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
