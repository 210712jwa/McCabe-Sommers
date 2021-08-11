package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.ClientDAO;
import com.revature.dao.ClientDAOImpl;
import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.ClientNotFoundException;
import com.revature.exception.DBException;
import com.revature.exception.InvalidInputException;
import com.revature.model.Account;
import com.revature.model.Client;

public class AccountService {

	private AccountDAO accountDao;
	private ClientDAO clientDao;

	public AccountService() {
		this.accountDao = new AccountDAOImpl();
		this.clientDao = new ClientDAOImpl();
	}

	public AccountService(ClientDAO clientDao, AccountDAO accountDao) {
		this.clientDao = clientDao;
		this.accountDao = accountDao;
	}

	public List<Account> getAllAccountsFromClient(String clientIDS)
			throws InvalidInputException, DBException, ClientNotFoundException {

		try {
			int clientID = Integer.parseInt(clientIDS);

			// checking here IF CLIENT EVEN EXISTS
			if (clientDao.getClientById(clientID) == null) {
				throw new ClientNotFoundException("Client with id " + clientID + " was not found");
			}

			List<Account> accounts = accountDao.getAllAccountsFromClient(clientID);

			return accounts;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + clientIDS + " but must be int");
		}

	}

	public Account getAccountByIdFromClient(String clientIDS, String accountIDS)
			throws InvalidInputException, DBException, ClientNotFoundException {

		try {
			int clientID = Integer.parseInt(clientIDS);
			int accountID = Integer.parseInt(accountIDS);

			// checking here IF CLIENT EVEN EXISTS
			if (clientDao.getClientById(clientID) == null) {
				throw new ClientNotFoundException("Client with id " + clientID + " was not found");
			}

			if (accountDao.getAccountByIdFromClient(clientID, accountID) == null) {
				throw new ClientNotFoundException("Account with id " + accountID + " was not found");
			}

			Account account = accountDao.getAccountByIdFromClient(clientID, accountID);

			return account;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + clientIDS + " but must be int");
		}

	}

	public Account addAccountByClientId(AddOrEditAccountDTO account) throws DBException, InvalidInputException {

		if (account.getClientID() < 0 || account.getClientID() > 999999999) {
			throw new InvalidInputException(
					"Invalid input. Client ID length must be greater then 0 and less then 10 integers long");
		}

		if (account.getAccountID() < 0 || account.getClientID() > 999999999) {
			throw new InvalidInputException(
					"Invalid input. Account ID length must be greater then 0 and less then 10 integers long");
		}

		if (account.getAccountBal() < 0) {
			throw new InvalidInputException("Invalid input. Account balance length must not be negative");
		}

		try {
			Account newAccount = accountDao.addAccountByClientId(account);

			return newAccount;
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		}
	}
	

	public Account editAccount(String sCID, String sAID, AddOrEditAccountDTO account)
			throws DBException, ClientNotFoundException, InvalidInputException {

		// before we edit ship, see if ship already exists
		try {
			int cID = Integer.parseInt(sCID);
			int aID = Integer.parseInt(sAID);

			if (clientDao.getClientById(cID) == null) {
				throw new ClientNotFoundException("Client with id " + cID + " was not found");
			}
			
			if (accountDao.getAccountByIdFromClient(cID, aID) == null) {
				throw new ClientNotFoundException("Account with id " + aID + " was not found");
			}

			// if client exists, we proceed to edit the client
			Account editedAccount = accountDao.editAccount(cID, aID, account);

			return editedAccount;

		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id and account id must be int");
		}

	}
	
	
	
	public void deleteAccountById(String sCID, String sAID) throws DBException, ClientNotFoundException, InvalidInputException {
		try {
			int cID = Integer.parseInt(sCID);
			int aID = Integer.parseInt(sAID);

			if (clientDao.getClientById(cID) == null) {
				throw new ClientNotFoundException("Client with id " + cID + " was not found");
			}
			
			if (accountDao.getAccountByIdFromClient(cID, aID) == null) {
				throw new ClientNotFoundException("Account with id " + aID + " was not found");
			}
			
			accountDao.deleteAccountById(cID, aID);
			
			
		} catch (SQLException e) {
			throw new DBException("An error occured while connecting to the Database.");
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id and account id must be int");
		}
	}
	
	
	

	public List<Account> getAllAccountsFromClientBtw(String clientIDS)
			throws InvalidInputException, DBException, ClientNotFoundException {

		try {
			int clientID = Integer.parseInt(clientIDS);

			// checking here IF CLIENT EVEN EXISTS
			if (clientDao.getClientById(clientID) == null) {
				throw new ClientNotFoundException("Client with id " + clientID + " was not found");
			}

			List<Account> accounts = accountDao.getAllAccountsFromClientBtw(clientID);

			return accounts;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} catch (NumberFormatException e) {
			throw new InvalidInputException("The input for client id was " + clientIDS + " but must be int");
		}

	}

}
