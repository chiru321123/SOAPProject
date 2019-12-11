package com.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.EmployeeRepository;

import in.co.employee.*;
@Endpoint
public class EmployeeEndPoint {

	private static final String NAMESPACE_URI = "http://www.employee.co.in";
	@Autowired
		private EmployeeRepository employeeRepository;

		@Autowired
		public EmployeeEndPoint(EmployeeRepository employeeRepository) {
			this.employeeRepository = employeeRepository;
		}

		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
		@ResponsePayload
		public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeRequest request) {
			System.err.println("chiru");
			GetEmployeeResponse response = new GetEmployeeResponse();
			response.setEmployee(employeeRepository.findEmployee(request.getEmployeeId()));
			return response;
		}
		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "createEmployeeRequest")
		@ResponsePayload
		public EmployeeResponse getcreateEmployee(@RequestPayload CreateEmployeeRequest request) {
			
			EmployeeResponse response = new EmployeeResponse();
			Employee emp=new Employee();
			emp.setDepartment(request.getDepartment());
			emp.setEmployeeId(request.getEmployeeId());
			emp.setEmployeeName(request.getEmployeeName());
			emp.setPhoneNo(request.getPhoneNo());
			emp.setSalary(request.getSalary());
			///Employee employee=employeeRepository.createEmployee(emp);
		//	System.err.println(employee.getEmployeeId()+employee.getEmployeeName());
			int n=employeeRepository.createEmployee(emp);
			if(n==1)
			response.setStatus("Created");
			else 
				response.setStatus("Employee id already present");
			return response;
		}
		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
		@ResponsePayload
		public EmployeeResponse delete(@RequestPayload DeleteEmployeeRequest request) {
			EmployeeResponse response=new EmployeeResponse();
			employeeRepository.delete(request.getEmployeeId());
			response.setStatus("Deleted");
			return response;
		}
		@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
		@ResponsePayload
		public EmployeeResponse getupdateEmployee(@RequestPayload UpdateEmployeeRequest request) {
			
			EmployeeResponse response = new EmployeeResponse();
			Employee emp=new Employee();
			emp.setDepartment(request.getDepartment());
			emp.setEmployeeId(request.getEmployeeId());
			emp.setEmployeeName(request.getEmployeeName());
			emp.setPhoneNo(request.getPhoneNo());
			emp.setSalary(request.getSalary());
			///Employee employee=employeeRepository.createEmployee(emp);
		//	System.err.println(employee.getEmployeeId()+employee.getEmployeeName());
			int n=employeeRepository.updateEmployee(emp);
			if(n==1)
			response.setStatus("updated");
			else 
				response.setStatus("Having some issue");
			return response;
		}
}
