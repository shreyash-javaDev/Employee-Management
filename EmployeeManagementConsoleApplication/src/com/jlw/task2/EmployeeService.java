package com.jlw.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class EmployeeService {

	private List <Employee> emps = new ArrayList();
	
	
	public void addEmployee(Employee emp) {
		emps.add(emp);
		System.out.println("Employee Added successfully!");
	}
	
	public void viewEmployees() {
		emps.forEach(emps-> System.out.println(emps));
		
	}
	
	public Employee searchEmployee(int id) throws EmployeeNotFoundException {
		return emps.stream()
				.filter(emp ->emp.getId() == id ).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException ("Employee ID "+ id + "not found!"));

	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException{
		Employee emp = searchEmployee(id);
		emps.remove(emp);
		
		System.out.println("Employee Deleted Successfully!");
		
	}
	public Optional<Employee > highestSalaryEmployee(){
		
		return emps.stream().max(Comparator.comparingDouble(Employee::getSalary));
		
	}
	
	public void employeesByDepertment(String deptName) {
		emps.stream()
		.filter(emp-> emp.getDepartment()
				.equalsIgnoreCase(deptName)).
				forEach(System.out::println);
	}

	
	
	
	
}
