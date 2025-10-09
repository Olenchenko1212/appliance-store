package com.epam.rd.autocode.assessment.appliances.model;

public class Employee extends User {

	private String department;

	public Employee() {
	}

	public Employee(long id, String name, String email, String password, String card) {
		super(id, name, email, password);
		this.department = card;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		if (department == null) {
			if (other.department != null) {
				return false;
			}
		} else if (!department.equals(other.department)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee{id=" + getId() + ", name='" + getName() + "', email='" + getEmail() + "', password='"
				+ getPassword() + "'department='" + department + "'}";
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String card) {
		this.department = card;
	}

}
