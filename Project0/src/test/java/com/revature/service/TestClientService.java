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

import com.revature.dao.ClientDAO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.exception.ClientNotFoundException;
import com.revature.exception.DBException;
import com.revature.exception.InvalidInputException;
import com.revature.model.Client;

public class TestClientService {
	
	private ClientService clientService;
	private ClientDAO clientDao;

	@Before
	public void setUp() throws Exception {
		this.clientDao = mock(ClientDAO.class); 
		
		this.clientService = new ClientService(clientDao); 
	}



	@Test
	public void test_getAllClients_positive() throws DBException, SQLException {
		List<Client> mockReturnValues = new ArrayList<>();
		mockReturnValues.add(new Client("Joe Shmo", 123456789));
		mockReturnValues.add(new Client("Man Child", 192837465));
		mockReturnValues.add(new Client("Dickie Betts", 987654321));
		
		when(this.clientDao.getAllClients()).thenReturn(mockReturnValues);
		
		List<Client> actual = clientService.getAllClients();
		
		List<Client> expected = new ArrayList<>();
		expected.add(new Client("Joe Shmo", 123456789));
		expected.add(new Client("Man Child", 192837465));
		expected.add(new Client("Dickie Betts", 987654321));
		
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = DBException.class)
	public void test_getAllClients_negative() throws DBException, SQLException {
		
		when(clientDao.getAllClients()).thenThrow(SQLException.class);
		
		clientService.getAllClients();
	}
	
	
	@Test
	public void test_getClientById_positive() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		when(clientDao.getClientById(eq(123456789))).thenReturn(new Client("Joe Schmo", 123456789));
		
		Client actual = clientService.getClientById("123456789");
		
		Client expected = new Client("Joe Schmo", 123456789);
		
		assertEquals(expected, actual);
	}
	
	
	@Test(expected = InvalidInputException.class)
	public void test_getClientById_negative() throws DBException, InvalidInputException, ClientNotFoundException {
		clientService.getClientById("whaaaa");
	}
	
	@Test(expected = ClientNotFoundException.class)
	public void test_getClientById_noIRLClient() throws DBException, ClientNotFoundException, InvalidInputException {
		clientService.getClientById("96024");
	}
	
	@Test(expected = DBException.class)
	public void test_getClientById_sQLException() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		when(clientDao.getClientById(anyInt())).thenThrow(SQLException.class);
		clientService.getClientById("96024");
	}
	
	@Test
	public void test_addClient_positive() throws SQLException, DBException, InvalidInputException {	
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
		
		when(clientDao.addClient(eq(dto))).thenReturn(new Client("Joe Schmo", 123456789));
		
		Client actual = clientService.addClient(dto);
		
		assertEquals(new Client("Joe Schmo", 123456789), actual);
	}
	
	@Test (expected = InvalidInputException.class)
	public void test_addClient_nameBlank() throws DBException, InvalidInputException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("");
		dto.setClientID(123456789);
		
		clientService.addClient(dto);
	}
	
	@Test (expected = InvalidInputException.class)
	public void test_addClient_nameSpaces() throws DBException, InvalidInputException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("                ");
		dto.setClientID(123456789);
		
		clientService.addClient(dto);
	}
	
	@Test(expected = InvalidInputException.class)
	public void test_addClient_negativeID() throws DBException, InvalidInputException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(-9);
		
		clientService.addClient(dto);
	}
	
	@Test
	public void test_addClient_nameBlankAndNegativeID() throws DBException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("");
		dto.setClientID(-9);
		
		try {
			clientService.addClient(dto);
			
			fail();
		} catch (InvalidInputException e) {
			assertEquals("Client feild must not be left empty and client ID length must "
					+ "be greater then 0 and less then 10 integers long", e.getMessage());
		}
	}
	
	@Test
	public void test_addClient_nameBlankAndIDTooBig() throws DBException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("");
		dto.setClientID(1111111111);
		
		try {
			clientService.addClient(dto);
			
			fail();
		} catch (InvalidInputException e) {
			assertEquals("Client feild must not be left empty and client ID length must "
					+ "be greater then 0 and less then 10 integers long", e.getMessage());
		}
	}
	
	@Test(expected = DBException.class)
	public void test_addClient_SQLException() throws SQLException, DBException, InvalidInputException {
		when(clientDao.addClient(any())).thenThrow(SQLException.class);
		
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
		clientService.addClient(dto);
	}
	
	@Test
	public void test_editClient_positive() throws DBException, ClientNotFoundException, InvalidInputException, SQLException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
				
		Client client96024 = new Client("Dickie Betts", 96024);
		when(clientDao.getClientById(eq(96024))).thenReturn(client96024);
		when(clientDao.editClient(eq(96024), eq(dto))).thenReturn(new Client("Joe Schmo", 123456789));
		
		Client actual = clientService.editClient("96024", dto);
		Client expected = new Client("Joe Schmo", 123456789);
		
		assertEquals(expected, actual);	
	}
	
	@Test(expected = ClientNotFoundException.class)
	public void test_editClient_clientNotFound() throws DBException, ClientNotFoundException, InvalidInputException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
		
		clientService.editClient("969", dto);
	}
	
	@Test(expected = InvalidInputException.class)
	public void test_editClient_invalidInput() throws DBException, ClientNotFoundException, InvalidInputException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
		
		clientService.editClient("DIY", dto);
	}
	
	@Test(expected = DBException.class)
	public void test_editClient_sQLException() throws DBException, ClientNotFoundException, InvalidInputException, SQLException {
		AddOrEditClientDTO dto = new AddOrEditClientDTO();
		dto.setName("Joe Schmo");
		dto.setClientID(123456789);
		
		when(clientDao.getClientById(eq(369))).thenReturn(new Client("John Jay", 369));		
		when(clientDao.editClient(eq(369), eq(dto))).thenThrow(SQLException.class);
		
		clientService.editClient("369", dto);
	}
	
	@Test(expected = ClientNotFoundException.class)
	public void test_deleteClientById_cNFException() throws SQLException, DBException, ClientNotFoundException, InvalidInputException {
		clientService.deleteClientById("838");		
	}
	
	@Test(expected = InvalidInputException.class)
	public void test_deleteClientById_invalidInput() throws DBException, ClientNotFoundException, InvalidInputException {		
		clientService.deleteClientById("DIY");
	}
	
	
	@Test(expected = DBException.class)
	public void test_deleteClientById_negative() throws DBException, SQLException, ClientNotFoundException, InvalidInputException {		
		when(clientDao.getClientById(eq(369))).thenReturn(new Client("John Jay", 369));		
		when(clientDao.getClientById(anyInt())).thenThrow(SQLException.class);
		
		clientService.deleteClientById("3232");
	}
}
