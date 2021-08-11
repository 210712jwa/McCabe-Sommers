package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Account;

public interface AccountDAO {
	
	List<Account> getAllAccountsFromClient(int clientID) throws SQLException;
	
	List<Account> getAllAccountsFromClientBtw(int clientID) throws SQLException;
	
	Account getAccountByIdFromClient(int clientID, int accountID) throws SQLException;
	
	Account addAccountByClientId(AddOrEditAccountDTO account) throws SQLException;
	
	Account editAccount(int clientID, int accountID, AddOrEditAccountDTO account) throws SQLException;
	
	void deleteAccountById(int clientID, int accountID) throws SQLException;

}
