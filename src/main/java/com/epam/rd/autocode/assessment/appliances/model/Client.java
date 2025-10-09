package com.epam.rd.autocode.assessment.appliances.model;

public class Client extends User {

	private String card;

	public Client() {
	}

	public Client(long id, String name, String email, String password, String department) {
		super(id, name, email, password);
		this.card = department;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((card == null) ? 0 : card.hashCode());
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
		Client other = (Client) obj;
		if (card == null) {
			if (other.card != null) {
				return false;
			}
		} else if (!card.equals(other.card)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Client{id=" + getId() + ", name='" + getName() + "', email='" + getEmail() + "', password='"
				+ getPassword() + "'card='" + card + "'}";
	}

	public String getCard() {
		return card;
	}

	public void setCard(String department) {
		this.card = department;
	}

}
