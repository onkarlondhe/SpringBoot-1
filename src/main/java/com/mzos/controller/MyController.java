package com.mzos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzos.employee.Employee;
import com.mzos.service.EmpService;

@RestController
public class MyController {
	
	@Autowired
	EmpService service;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(service.insertEmployee(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmpById(@PathVariable int empId) {
		return service.getEmp(empId);
	}
	
	@PostMapping("/updateEmp")
	
	public Employee editEmp(@RequestBody Employee emp) {
		return service.updateEmp(emp);
	}
	
	@DeleteMapping("deleteEmp/{empId}")
	public ResponseEntity<Boolean> removeEmp(@PathVariable int empId) {
		return new ResponseEntity<Boolean>(service.deleteEmp(empId), HttpStatus.NO_CONTENT);
	}
}
