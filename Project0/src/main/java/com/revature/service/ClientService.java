package com.revature.service;

import java.sql.SQLException;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.app.App;
import com.revature.dao.ClientDAO;
import com.revature.dao.ClientDAOImpl;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.ClientNotFoundException;
import com.revature.exception.DBException;
import com.revature.exception.InvalidInputException;
import com.revature.model.Client;

public class ClientService {
	
//	private static Logger log = LoggerFactory.getLogger(App.class);
	
	private ClientDAO clientDao;
	
	public ClientService() {
		this.clientDao = new ClientDAOImpl();
	}
	
	public ClientService(ClientDAO mockedDaoObject) {
		this.clientDao = mockedDaoObject;
	}
	
	public List<Client> getAllClients() throws DBException{
		List<Client> clients;
		try {
			clients = clientDao.getAllClients();
			
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		}
		return clients;
	}
	
	
	
	public Client getClientById(String sId) throws DBException, ClientNotFoundException, InvalidInputException {
				
		try {
			int id = Integer.parseInt(sId);
			
			Client client = clientDao.getClientById(id);
			
			if (client == null) {
				throw new ClientNotFoundException("Client with id " + id + " was not found");
			}
			
			return client;
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + sId + " but must be int");
		}
	}
	
	public Client addClient(AddOrEditClientDTO client) throws DBException, InvalidInputException {
		if(client.getName().trim().equals("") && client.getClientID() < 0 || client.getClientID() > 999999999) {
			throw new InvalidInputException("Client feild must not be left empty and client "
					+ "ID length must be greater then 0 and less then 10 integers long");
		}
		
		if (client.getName().trim().equals("")) {
			throw new InvalidInputException("Client feild must not be left empty");
		}
		
		if (client.getClientID() < 0 || client.getClientID() > 999999999) {
			throw new InvalidInputException("Invalid input. Client ID length must be greater then 0 and less then 10 integers long");
		}
		
		try {
			Client newClient = clientDao.addClient(client);
			
			return newClient;
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		}
	}
	
	public Client editClient(String sId, AddOrEditClientDTO client) throws DBException, ClientNotFoundException, InvalidInputException {
		
		//before we edit ship, see if ship already exists
		try {
			int id = Integer.parseInt(sId);
			
			if (clientDao.getClientById(id) == null) {
				throw new ClientNotFoundException("Client with id " + id + " was not found");
			}
			
			//if client exists, we proceed to edit the client
			Client editedClient = clientDao.editClient(id, client);
			
			return editedClient;
			
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + sId + " but must be int");
		}

	}
	
	public void deleteClientById(String sId) throws DBException, ClientNotFoundException, InvalidInputException {
		try {
			int id = Integer.parseInt(sId);
			
			Client client = clientDao.getClientById(id);
			
			if (client == null) {
				throw new ClientNotFoundException("Client with id " + id + " was not found");
			}
			
			clientDao.deleteClientById(id);
			
			
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + sId + " but must be int");
		}
	}

}
