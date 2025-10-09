package com.epam.rd.autocode.assessment.appliances.model;

public class Appliance {
	private long id;
	private String name;
	private Category category;
	private String model;
	private Manufacturer manufacturer;
	private PowerType powerType;
	private String characteristic;
	private String description;
	private int power;

	public Appliance() {
	}

	public Appliance(long id, String name, Category category, String model, Manufacturer manufacturer,
			PowerType powerType, String characteristic, String description, int power) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.model = model;
		this.manufacturer = manufacturer;
		this.powerType = powerType;
		this.characteristic = characteristic;
		this.description = description;
		this.power = power;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((characteristic == null) ? 0 : characteristic.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + power;
		result = prime * result + ((powerType == null) ? 0 : powerType.hashCode());
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
		Appliance other = (Appliance) obj;
		if (category != other.category) {
			return false;
		}
		if (characteristic == null) {
			if (other.characteristic != null) {
				return false;
			}
		} else if (!characteristic.equals(other.characteristic)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (manufacturer == null) {
			if (other.manufacturer != null) {
				return false;
			}
		} else if (!manufacturer.equals(other.manufacturer)) {
			return false;
		}
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (power != other.power) {
			return false;
		}
		if (powerType != other.powerType) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Appliance{id=" + id + ", name='" + name + "', category=" + category + ", model='" + model
				+ "', manufacturer=" + manufacturer + ", powerType=" + powerType + ", characteristic='" + characteristic
				+ "', description='" + description + "', power=" + power + "}";
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public String getModel() {
		return model;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public PowerType getPowerType() {
		return powerType;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public String getDescription() {
		return description;
	}

	public int getPower() {
		return power;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setPowerType(PowerType powerType) {
		this.powerType = powerType;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
