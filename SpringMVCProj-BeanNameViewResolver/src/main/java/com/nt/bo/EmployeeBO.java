package com.nt.bo;



public class EmployeeBO {
private int empNo;
private String empName;
private String job;
private double salary;
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
	return "EmployeeBO [empNo=" + empNo + ", empName=" + empName + ", job=" + job + ", salary=" + salary + "]";
}


}
