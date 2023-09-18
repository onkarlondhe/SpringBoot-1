package com.mzos.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mzos.employee.Employee;
@Repository
public class EmployeeRepo {

	ArrayList<Employee> array = new ArrayList<>(Arrays.asList(new Employee(1, "Ram", 50000),new Employee(2, "Sham", 60000)));
	
		public List<Employee> selectAllEmployee() {

			return array;
		}

		public boolean insertEmployee(Employee emp) {

			return array.add(emp);
		}

		public List<Employee> getEmp(int empId) {
			List<Employee> e = array.stream().filter(emp->emp.getEmpId()==empId).collect(Collectors.toList());
			return e;
		}

		public Employee updateEmp(Employee emp) {
			for(int i=0; i<=array.size(); i++) {
				if(array.get(i).getEmpId()==emp.getEmpId())
					return array.set(i, emp);
			}
			return null;
		}

		public boolean deleteEmp(int empId) {			
			 return array.removeIf(emp->emp.getEmpId()==empId);
		}

		 
		

}
