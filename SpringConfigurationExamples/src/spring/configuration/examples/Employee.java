package spring.configuration.examples;

import java.util.List;

public class Employee {
	private String employeeName;
	private int employeeId;
	private Address address;
	private List<String> projectList;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor fired");
	}
	
	Employee(int employeeId){
		this.employeeId = employeeId;
		System.out.println("constructor with employeeId is fired");
	}
	
	public Employee(String employeeName) {
		this.employeeName = employeeName;
		System.out.println("constructor with employeeName is fired");
	}
	
	public Employee(String employeeName, int employeeId) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		System.out.println("constructor with employeeName and employeeId is fired");
	}
	
	public Employee(String employeeName, int employeeId, Address address) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.address = address;
		System.out.println("constructor with employeeName and employeeId and address is fired");
	}
	
	public Employee(String employeeName, int employeeId, Address address, List<String> projectList) {
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.address = address;
		this.projectList = projectList;
		System.out.println("constructor with employeeName and employeeId and address is fired");
	}
	

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		System.out.println("setEmployeeName() is called");
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		System.out.println("setEmployeeId() is called");
		this.employeeId = employeeId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setAddress() is called");
		this.address = address;
	}
	
	public List<String> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<String> projectList) {
		System.out.println("setProjectList() is called");
		this.projectList = projectList;
	}

	public void showData(String objectId) {
		System.out.println("object Id : "+objectId+ " Employee Name : "+employeeName+
				" EmployeeId : "+employeeId+" address : "+address+" ProjectList : "+projectList);
	}
}
