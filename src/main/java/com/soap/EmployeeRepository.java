package com.soap;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import in.co.employee.Employee;
import in.co.employee.Departments;



@Component
public class EmployeeRepository {

	private static final Map<Integer, Employee> employees = new HashMap<Integer,Employee>();
	
	@PostConstruct
	public void initData() {
		System.err.println("chiru in constructor");
		Employee e1=new Employee();
		e1.setEmployeeId(101);
		e1.setEmployeeName("sasidhar");
		e1.setSalary(1200050);
		e1.setPhoneNo("9874561230");
		e1.setDepartment(Departments.MANAGER);
		employees.put(e1.getEmployeeId(),e1);
		
		Employee e2=new Employee();
		e2.setEmployeeId(102);
		e2.setEmployeeName("chiru");
		e2.setSalary(1200050);
		e2.setPhoneNo("9874561230");
		e2.setDepartment(Departments.IT);
		employees.put(e2.getEmployeeId(),e2);
		
		Employee e3=new Employee();
		e3.setEmployeeId(103);
		e3.setEmployeeName("Dheeraj");
		e3.setSalary(1200050);
		e3.setPhoneNo("9874561230");
		e3.setDepartment(Departments.MANAGER);
		employees.put(e3.getEmployeeId(),e3);
	}
	public Employee findEmployee(int id) {
		Assert.notNull(employees.get(id), "Invalid Employee Id");
		return employees.get(id);
	}
	public int createEmployee(Employee emp) {
		if(employees.get(emp.getEmployeeId())==null) {
			System.err.println("count=        "+employees.size());
			employees.put(emp.getEmployeeId(),emp);
			return 1;
		}
		/*System.err.println("count=        "+employees.size());
		return employees.get(emp.getEmployeeId());*/
		else return 0;
	}
	public void delete(int id) {
		System.err.println("count=        "+employees.size());
		employees.remove(id);
		System.err.println("count=        "+employees.size());
	}
	public int updateEmployee(Employee emp) {
		if(employees.get(emp.getEmployeeId())!=null) {
			System.err.println("count=        "+employees.size());
			employees.put(emp.getEmployeeId(),emp);
			return 1;
		}
		/*System.err.println("count=        "+employees.size());
		return employees.get(emp.getEmployeeId());*/
		else return 0;
	}
}
