package com.jspider.empinfosystem.bean;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 11, 2014
 * @projectName : assignment_1_proj
 */
public class Employee implements Comparable<Employee>{
	/*
	 * instance variables or fields
	 */
	private int empID;
	private String empFirstName;
	private String empLastName;
	private double empSal;
	private String empDept;

	// default constructor
	public Employee() {
	}


	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", empSal=" + empSal
				+ ", empDept=" + empDept + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.empID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empID != other.empID) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Employee o) {
		return this.getEmpID()-o.getEmpID();
	}
}

