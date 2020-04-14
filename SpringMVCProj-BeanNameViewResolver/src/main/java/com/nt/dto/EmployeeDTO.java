package com.nt.dto;

import java.io.Serializable;


public class EmployeeDTO implements Serializable {
	private int srNo;
	private int empNo;
	private String empName;
	private String job;
	private double salary;
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmployeeDTO [srNo=" + srNo + ", empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", salary="
				+ salary + "]";
	}
	
	
}
