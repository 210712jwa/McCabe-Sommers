package com.revature.controller;

import java.util.List;

import com.revature.model.Client;
import com.revature.service.ClientService;
import com.revature.dto.AddOrEditClientDTO;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientController implements Controller {
	
	private ClientService cS;
	
	public ClientController() {
		this.cS = new ClientService();
	}
	
	private Handler getAllClients = (ctx) -> {
		List<Client> clients = cS.getAllClients();
		
		ctx.status(200);
		ctx.json(clients);
	};
	
	private Handler getClientById = (ctx) -> {
		String clientid = ctx.pathParam("clientID");
		
		Client client = cS.getClientById(clientid);
		
		ctx.json(client);
	};
	
	private Handler addClient = (ctx) -> {
		AddOrEditClientDTO clientToAdd = ctx.bodyAsClass(AddOrEditClientDTO.class);
		
		Client addedClient = cS.addClient(clientToAdd);
		ctx.json(addedClient);
	};
	
	private Handler editClient = (ctx) -> {
		AddOrEditClientDTO clientToEdit = ctx.bodyAsClass(AddOrEditClientDTO.class);
		
		String clientID = ctx.pathParam("clientID");
		Client editedClient = cS.editClient(clientID, clientToEdit);
		
		ctx.json(editedClient);
	};
	
	private Handler deleteClient = (ctx) -> {
		String clientid = ctx.pathParam("clientID");
		
		cS.deleteClientById(clientid);
		
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/client", getAllClients);
		app.get("/client/:clientID", getClientById);
		app.post("/client", addClient);
		app.put("/client/:clientID", editClient);
		app.delete("/client/:clientID", deleteClient);
	}

}
