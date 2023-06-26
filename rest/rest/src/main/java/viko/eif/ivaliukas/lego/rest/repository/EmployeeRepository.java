package viko.eif.ivaliukas.lego.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viko.eif.ivaliukas.lego.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
