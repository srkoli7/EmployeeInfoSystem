package com.jspider.empinfosystem.bean;

/**
 * @author : Santosh Koli
 * @createdDate : Jun 12, 2014
 * @projectName : assignment_1_proj
 */
public class Department implements Comparable<Department>{
	String deptName;

	public Department() {
		super();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((deptName == null) ? 0 : deptName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Department)) {
			return false;
		}
		Department other = (Department) obj;
		if (deptName == null) {
			if (other.deptName != null) {
				return false;
			}
		} else if (!deptName.equals(other.deptName)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Department o) {
		return this.getDeptName().compareToIgnoreCase(o.getDeptName());
	}
		
}

