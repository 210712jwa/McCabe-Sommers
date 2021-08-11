package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Client;

public interface ClientDAO {
	
	public abstract List<Client> getAllClients() throws SQLException;
	
	public abstract Client getClientById(int clientID) throws SQLException;
		
	//using addclientdto, dto used to pass data around that might not completely conform to the actual "Model" class
	public abstract Client addClient(AddOrEditClientDTO client) throws SQLException;
	
	public abstract Client editClient(int clientID, AddOrEditClientDTO client) throws SQLException;
	
	public abstract void deleteClientById(int clientID) throws SQLException;
	
	

}
