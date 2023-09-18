package com.mzos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mzos.employee.Employee;
import com.mzos.repository.EmployeeRepo;
@Service
public class EmpService {
	
	@Autowired
	EmployeeRepo repo;
	
	public List<Employee> getAllEmployee() {

		return repo.selectAllEmployee();
	}

	public Employee insertEmployee(Employee emp) {

		if(repo.insertEmployee(emp))
			return emp;
		else
			return null;
	}

	public Employee getEmp(int empId) {
		if(repo.getEmp(empId).size()>0)
			return repo.getEmp(empId).get(0);
		else
			return null;
	}

	public Employee updateEmp(Employee emp) {
		if(repo.updateEmp(emp)==null)
			return null;
		else
			return emp;
	}

	public boolean deleteEmp(int empId) {

		return repo.deleteEmp(empId);
	}

	 

	 

}
