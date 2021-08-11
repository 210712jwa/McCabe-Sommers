package com.revature.model;

public class Account {	
	
	private int accountID;
	private int clientID;
	private double accountBal;
	
	public Account() {
		super();
	}
	
	public Account(int accountID, int clientID, double accountBal) {

		this.accountID = accountID;
		this.clientID = clientID;
		this.accountBal = accountBal;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public double getAccountBal() {
		return accountBal;
	}

	public void setAccountBal(double accountBal) {
		this.accountBal = accountBal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountID;
		result = prime * result + clientID;
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBal) != Double.doubleToLongBits(other.accountBal)) {
			return false;
		}
		if (accountID != other.accountID) {
			return false;
		}
		if (clientID != other.clientID) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", clientID=" + clientID + ", accountBal=" + accountBal + "]";
	}

	
	



}
