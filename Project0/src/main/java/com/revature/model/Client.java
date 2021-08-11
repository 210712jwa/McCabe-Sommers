package com.revature.model;

public class Client {
	

	private String name;
	private int clientID;
	

	public Client() {
		super();
	}
	

	public Client(String name, int client_id) {

		this.name = name;
		this.clientID = client_id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClient_id() {
		return clientID;
	}

	public void setClient_id(int client_id) {
		this.clientID = client_id;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clientID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (clientID != other.clientID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", client_id=" + clientID + "]";
	}
	
	

}
