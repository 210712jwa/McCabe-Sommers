package com.revature.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.revature.dao.AccountDAO;
import com.revature.dao.ClientDAO;
import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.ClientNotFoundException;
import com.revature.exception.DBException;
import com.revature.exception.InvalidInputException;
import com.revature.model.Account;
import com.revature.model.Client;

public class TestAccountService {

	private AccountService accountService;
	private ClientDAO clientDao;
	private AccountDAO accountDao;

	@Before
	public void setUp() throws Exception {
		this.clientDao = mock(ClientDAO.class);

		this.accountDao = mock(AccountDAO.class);

		this.accountService = new AccountService(clientDao, accountDao); 
	}

	@Test
	public void test_getAllAccountsFromClient_positive()
			throws InvalidInputException, DBException, ClientNotFoundException, SQLException {

		when(clientDao.getClientById(eq(888))).thenReturn(new Client("Ginger Baker", 888));

		List<Account> mockAccounts = new ArrayList<>();
		mockAccounts.add(new Account(12345, 888, 30));
		mockAccounts.add(new Account(54321, 888, 440.4));

		when(accountDao.getAllAccountsFromClient(eq(888))).thenReturn(mockAccounts);

		List<Account> actual = accountService.getAllAccountsFromClient("888");

		assertEquals(mockAccounts, actual);
	}

	@Test(expected = ClientNotFoundException.class)
	public void test_getAllAccountsFromClient_clientNotFound()
			throws InvalidInputException, DBException, ClientNotFoundException, SQLException {
		when(clientDao.getClientById(eq(888))).thenReturn(null);

		accountService.getAllAccountsFromClient("888");

	}

	@Test(expected = InvalidInputException.class)
	public void test_getAllAccountsFromClient_invalidInput()
			throws DBException, InvalidInputException, ClientNotFoundException {
		accountService.getAllAccountsFromClient("whaaaa");
	}

	@Test(expected = DBException.class)
	public void test_getClientById_sQLException()
			throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		when(clientDao.getClientById(anyInt())).thenThrow(SQLException.class);
		accountService.getAllAccountsFromClient("96024");
	}

	@Test(expected = DBException.class)
	public void test_getAllAccountsFromClient_sQLException_fromAccountDao_getAllPiratesFromShip()
			throws SQLException, InvalidInputException, DBException, ClientNotFoundException {
		when(clientDao.getClientById(eq(444))).thenReturn(new Client("Olivia Hurtz", 444));
		when(accountDao.getAllAccountsFromClient(eq(444))).thenThrow(SQLException.class);

		accountService.getAllAccountsFromClient("444");
	}
	
	@Test
	public void test_getAccountById_positive() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		when(clientDao.getClientById(eq(123456789))).thenReturn(new Client("Joe Shmo", 123456789));
		when(accountDao.getAccountByIdFromClient(eq(123456789), eq(222))).thenReturn(new Account(222, 123456789, 600.01));
		
		Account actual = accountService.getAccountByIdFromClient("123456789", "222");
		
		Account expected = new Account(222, 123456789, 600.01);
		
		assertEquals(expected, actual);
	}
	
	@Test(expected = InvalidInputException.class)
	public void test_getAccountsById_negative() throws DBException, InvalidInputException, ClientNotFoundException {
		accountService.getAccountByIdFromClient("whaaaa", "naaaaa");
	}
	
	@Test(expected = ClientNotFoundException.class)
	public void test_getAccountsById_noIRLClient() throws DBException, ClientNotFoundException, InvalidInputException {
		accountService.getAccountByIdFromClient("96024", "111");
	}
	
	@Test(expected = DBException.class)
	public void test_getAccountsById_sQLException() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		when(clientDao.getClientById(anyInt())).thenThrow(SQLException.class);
		accountService.getAccountByIdFromClient("96024", "112");
	}
	
	
	
	
	@Test(expected = ClientNotFoundException.class)
	public void test_deleteClientById_cNFException() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		accountService.deleteAccountById("838", "484");		
	}
	
	@Test(expected = InvalidInputException.class)
	public void test_deleteClientById_invalidInput() throws DBException, ClientNotFoundException, InvalidInputException {		
		accountService.deleteAccountById("DIY", "IKO");
	}
	
	
	@Test(expected = ClientNotFoundException.class)
	public void test_deleteClientById_negative() throws DBException, SQLException, ClientNotFoundException, InvalidInputException {		
		when(clientDao.getClientById(eq(369))).thenReturn(null);		
		
		accountService.deleteAccountById("3232", "4567");
	}
	
	@Test(expected = DBException.class)
	public void test_deleteAccountById_negative() throws DBException, SQLException, ClientNotFoundException, InvalidInputException {				
		when(clientDao.getClientById(anyInt())).thenThrow(SQLException.class);
		
		accountService.deleteAccountById("3232", "2982");
	}
	

}
