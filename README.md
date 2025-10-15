## Appliances Project

A small domain model of an appliance store. The project defines domain entities (models), enums, and service interfaces, plus a skeleton implementation `Shop`.

### Package structure
- `com.epam.rd.autocode.assessment.appliances.model`: domain models and enums
- `com.epam.rd.autocode.assessment.appliances.stream`: service-layer interfaces and the `Shop` class

### Classes and enums
- `User`: base user class (id, name, email, password)
- `Client` extends `User`: customer (card)
- `Employee` extends `User`: employee (department)
- `Manufacturer`: manufacturer (id, name)
- `Appliance`: product/device (id, name, category, model, manufacturer, powerType, characteristic, description, power)
- `Order`: order (id, client, employee, appliances as `Map<Appliance, BigDecimal>`)
- `Category` (enum): BIG, SMALL
- `PowerType` (enum): AC220, AC110, ACCUMULATOR

### Service-layer interfaces
- `Add`: addClient, addEmployee, addAppliance, addOrder, addManufacturer
- `Find`: findManufacturerById, findManufacturerByName, findOrderByEmployee, findCheapestOrder, findMostExpensiveOrder
- `Sort`: sortManufacturersByName, sortOrderByClientId, sortAppliancesByCategory, sortOrderByAmount
- `Shop` implements: `Add`, `Find`, `Sort`

### UML diagram (Mermaid)
```mermaid
classDiagram
  direction TB

  class User {
    - long id
    - String name
    - String email
    - String password
  }

  class Client {
    - String card
  }

  class Employee {
    - String department
  }

  User <|-- Client
  User <|-- Employee

  class Manufacturer {
    - long id
    - String name
  }

  class Category {
    <<enumeration>>
    + BIG
    + SMALL
  }

  class PowerType {
    <<enumeration>>
    + AC220
    + AC110
    + ACCUMULATOR
  }

  class Appliance {
    - long id
    - String name
    - Category category
    - String model
    - Manufacturer manufacturer
    - PowerType powerType
    - String characteristic
    - String description
    - int power
  }

  class Order {
    - long id
    - Client client
    - Employee employee
    - Map<Appliance, BigDecimal> appliances
  }

  class Add {
    <<interface>>
    + void addClient(Client)
    + void addEmployee(Employee)
    + void addAppliance(Appliance)
    + void addOrder(Order)
    + void addManufacturer(Manufacturer)
  }

  class Find {
    <<interface>>
    + Manufacturer findManufacturerById(long)
    + Manufacturer findManufacturerByName(String)
    + List~Order~ findOrderByEmployee(Employee)
    + Order findCheapestOrder()
    + Order findMostExpensiveOrder()
  }

  class Sort {
    <<interface>>
    + List~Manufacturer~ sortManufacturersByName()
    + List~Order~ sortOrderByClientId()
    + List~Appliance~ sortAppliancesByCategory()
    + List~Order~ sortOrderByAmount()
  }

  class Shop

  Shop ..|> Add
  Shop ..|> Find
  Shop ..|> Sort

  Appliance --> Manufacturer : manufacturer
  Appliance --> Category : category
  Appliance --> PowerType : powerType

  Order --> Client : client
  Order --> Employee : employee
  Order "1" --> "*" Appliance : appliances
```

### Source navigation
- Models: `src/main/java/com/epam/rd/autocode/assessment/appliances/model/*`
- Interfaces and `Shop`: `src/main/java/com/epam/rd/autocode/assessment/appliances/stream/*`
- Tests: `src/test/java/com/epam/rd/autocode/assessment/appliances/**/*`

### Notes
- The diagram reflects the actual fields and method signatures from the source code.
- A `Appliances.puml` file exists in the root, but the Mermaid diagram above is the source of truth for the current code state.
