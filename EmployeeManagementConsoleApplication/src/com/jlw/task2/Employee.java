package com.jlw.task2;

public class Employee {

	private int id ;
	private String name;
	private String dept;
	private double sal;
	
	
    public Employee(int id, String name, String dept, double sal) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return dept;
    }

    public double getSalary() {
        return sal;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id +
                ", name=" + name +
                ", department=" + dept +
                ", salary=" + sal + "]";
    }
	
	
}
