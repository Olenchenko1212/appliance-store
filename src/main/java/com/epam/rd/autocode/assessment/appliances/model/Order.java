package com.epam.rd.autocode.assessment.appliances.model;

import java.math.BigDecimal;
import java.util.Map;

public class Order {
	long id;
	Client client;
	Employee employee;
	Map<Appliance, BigDecimal> appliances;

	public Order() {
	}

	public Order(long id, Client client, Employee employee, Map<Appliance, BigDecimal> appliances) {
		this.id = id;
		this.client = client;
		this.employee = employee;
		this.appliances = appliances;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appliances == null) ? 0 : appliances.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (appliances == null) {
			if (other.appliances != null) {
				return false;
			}
		} else if (!appliances.equals(other.appliances)) {
			return false;
		}
		if (client == null) {
			if (other.client != null) {
				return false;
			}
		} else if (!client.equals(other.client)) {
			return false;
		}
		if (employee == null) {
			if (other.employee != null) {
				return false;
			}
		} else if (!employee.equals(other.employee)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Order{id=" + id + ", client=" + client + ", employee=" + employee + ", appliances=" + appliances + "}";
	}

	public long getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Map<Appliance, BigDecimal> getAppliances() {
		return appliances;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setAppliances(Map<Appliance, BigDecimal> appliances) {
		this.appliances = appliances;
	}

}
