package com.revature.controller;

import java.util.List;

import com.revature.dto.AddOrEditAccountDTO;
import com.revature.dto.AddOrEditClientDTO;
import com.revature.model.Account;
import com.revature.model.Client;
import com.revature.service.AccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController implements Controller{
	
	private AccountService accountService;
	
	public AccountController() {
		this.accountService = new AccountService();
	}
	
	private Handler getAccountFromClient = (ctx) -> {
		String clientID = ctx.pathParam("clientID");
		
				
		
		List<Account> accountsFromClient = accountService.getAllAccountsFromClient(clientID);
		
		ctx.json(accountsFromClient);
	};
	
	
	private Handler getAccountByIdFromClient = (ctx) -> {
		String clientID = ctx.pathParam("clientID");
		String accountID = ctx.pathParam("accountID");
		
		Account accountFromClient = accountService.getAccountByIdFromClient(clientID, accountID);
		
		ctx.json(accountFromClient);
		
	};
	
	
	
	private Handler getAccountFromClientBtw = (ctx) -> {
		String clientID = ctx.pathParam("clientID");
		
		List<Account> accountsFromClient = accountService.getAllAccountsFromClientBtw(clientID);
		
		ctx.json(accountsFromClient);
	};
	
	
	
	private Handler addAccountByClientId = (ctx) -> {
		AddOrEditAccountDTO accountToAdd = ctx.bodyAsClass(AddOrEditAccountDTO.class);
		
		Account newAccount = accountService.addAccountByClientId(accountToAdd);
		ctx.json(newAccount);
	};
	
	
	
	private Handler editAccount = (ctx) -> {
		AddOrEditAccountDTO accountToEdit = ctx.bodyAsClass(AddOrEditAccountDTO.class);
		
		String clientID = ctx.pathParam("clientID");
		String accountID = ctx.pathParam("accountID");
		
		Account editedClient = accountService.editAccount(clientID, accountID, accountToEdit);
		
		ctx.json(editedClient);
	};
	
	private Handler deleteAccount = (ctx) -> {
		String clientid = ctx.pathParam("clientID");
		String accountid = ctx.pathParam("accountID");
		
		accountService.deleteAccountById(clientid, accountid);
		
	};


	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/client/:clientID/account", getAccountFromClient);
		app.get("/client/:clientID/account/:accountID", getAccountByIdFromClient);
		app.get("/client/:clientID/account?amountLessThan=2000&amountGreaterThan=400", getAccountFromClientBtw);
		app.post("/client/:clientID/account", addAccountByClientId);
		app.put("/client/:clientID/account/:accountID", editAccount);
		app.delete("/client/:clientID/account/:accountID", deleteAccount);
	}

}
