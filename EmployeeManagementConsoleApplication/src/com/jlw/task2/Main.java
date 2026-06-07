package com.jlw.task2;

import java.util.Optional;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {


		 Scanner sc = new Scanner(System.in);

	        EmployeeService service = new EmployeeService();

	        int choice;

	        do {

	            System.out.println("\n===== Employee Management =====");
	            System.out.println("1. Add Employee");
	            System.out.println("2. View Employees");
	            System.out.println("3. Search Employee");
	            System.out.println("4. Delete Employee");
	            System.out.println("5. Highest Salary Employee");
	            System.out.println("6. Employees By Department");
	            System.out.println("7. Exit");

	            System.out.print("Enter Choice: ");
	            choice = sc.nextInt();

	            switch (choice) {

	                case 1:

	                    System.out.print("Enter ID: ");
	                    int id = sc.nextInt();

	                    sc.nextLine();

	                    System.out.print("Enter Name: ");
	                    String name = sc.nextLine();

	                    System.out.print("Enter Department: ");
	                    String dept = sc.nextLine();

	                    System.out.print("Enter Salary: ");
	                    double salary = sc.nextDouble();

	                    service.addEmployee(
	                            new Employee(id, name, dept, salary));

	                    break;

	                case 2:

	                    service.viewEmployees();
	                    break;

	                case 3:

	                    try {
	                        System.out.print("Enter Employee ID: ");
	                        int searchId = sc.nextInt();

	                        Employee emp =
	                                service.searchEmployee(searchId);

	                        System.out.println(emp);

	                    } catch (EmployeeNotFoundException e) {
	                        System.out.println(e.getMessage());
	                    }

	                    break;

	                case 4:

	                    try {

	                        System.out.print("Enter Employee ID: ");
	                        int deleteId = sc.nextInt();

	                        service.deleteEmployee(deleteId);

	                    } catch (EmployeeNotFoundException e) {
	                        System.out.println(e.getMessage());
	                    }

	                    break;

	                case 5:

	                    Optional<Employee> highest =
	                            service.highestSalaryEmployee();

	                    highest.ifPresent(System.out::println);

	                    break;

	                case 6:

	                    sc.nextLine();

	                    System.out.print("Enter Department: ");
	                    String department = sc.nextLine();

	                    service.employeesByDepertment(department);

	                    break;

	                case 7:

	                    System.out.println("Thank You!");
	                    break;

	                default:

	                    System.out.println("Invalid Choice");
	            }

	        } while (choice != 7);

	        sc.close();
	    }
	}
	