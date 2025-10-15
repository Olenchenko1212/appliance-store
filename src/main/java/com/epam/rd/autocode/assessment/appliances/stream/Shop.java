package com.epam.rd.autocode.assessment.appliances.stream;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Objects;
import java.util.stream.Collectors;

import com.epam.rd.autocode.assessment.appliances.model.Appliance;
import com.epam.rd.autocode.assessment.appliances.model.Client;
import com.epam.rd.autocode.assessment.appliances.model.Employee;
import com.epam.rd.autocode.assessment.appliances.model.Manufacturer;
import com.epam.rd.autocode.assessment.appliances.model.Order;

public class Shop implements Add, Find, Sort {

  private Set<Client> clients = new HashSet<>();
	private Set<Employee> employees = new HashSet<>();
	private Set<Order> orders = new HashSet<>();
	private Set<Appliance> appliances = new HashSet<>();
	private Set<Manufacturer> manufacturers = new HashSet<>();

	public Set<Client> getClients() {
		return clients;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public Set<Appliance> getAppliances() {
		return appliances;
	}

	public Set<Manufacturer> getManufacturers() {
		return manufacturers;
	}

//ADD METHODS
	@Override
	public void addClient(Client client) {
		clients.add(client);
	}

	@Override
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public void addAppliance(Appliance appliance) {
		appliances.add(appliance);
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public void addManufacturer(Manufacturer manufacturer) {
		manufacturers.add(manufacturer);
	}

//SORT METHODS 	

	@Override
	public List<Manufacturer> sortManufacturersByName() {
		return manufacturers.stream().sorted(Comparator.comparing(Manufacturer::getName))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<Order> sortOrderByClientId() {
		return orders.stream().sorted(Comparator.comparingLong(order -> order.getClient().getId()))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<Appliance> sortAppliancesByCategory() {
		return appliances.stream().sorted(Comparator.comparingLong(a -> a.getCategory().ordinal()))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public List<Order> sortOrderByAmount() {
		return orders.stream()
				.sorted(Comparator.comparing(order -> order.getAppliances().values().stream()
						.max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO)))
				.collect(Collectors.toCollection(LinkedList::new));
	}

//FIND METHODS

	@Override
	public Manufacturer findManufacturerById(long id) {
		return manufacturers.stream().filter(manufacturer -> manufacturer.getId() == id).findAny()
				.orElseThrow(() -> new RuntimeException(String.format("Manufacturer with id=%d was not found", id)));
	}

	@Override
	public Manufacturer findManufacturerByName(String name) {
		return manufacturers.stream().filter(manufacturer -> manufacturer.getName().equals(name)).findAny().orElseThrow(
				() -> new RuntimeException(String.format("Manufacturer with name=%s was not found", name)));
	}

	@Override
	public List<Order> findOrderByEmployee(Employee employee) {
		return orders.stream().filter(order -> order.getEmployee().equals(employee)).collect(Collectors.toList());
	}

	@Override
	public Order findCheapestOrder() {
		return orders.stream()
				.min(Comparator.comparing(order -> order.getAppliances().values().stream()
						.max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO)))
				.orElseThrow(() -> new RuntimeException("Order not found"));
	}

	@Override
	public Order findMostExpensiveOrder() {
		return orders.stream().max(Comparator.comparing(
				obj -> obj.getAppliances().values().stream().max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO)))
				.orElseThrow(() -> new RuntimeException("Order not found"));
	}
}
