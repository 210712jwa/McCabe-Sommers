package com.revature.controller;

import com.revature.dto.ExceptionDTO;
import com.revature.exception.ClientNotFoundException;
import com.revature.exception.DBException;
import com.revature.exception.InvalidInputException;

import io.javalin.Javalin;
import io.javalin.http.ExceptionHandler;

public class ExceptionController implements Controller {
	
	private ExceptionHandler<DBException> dbExceptionHandler = (e, ctx) -> {
		ctx.status(500);
		
		ExceptionDTO stat = new ExceptionDTO();
		stat.setMessage(e.getMessage());
		
		ctx.json(stat);
	};
	
	private ExceptionHandler<ClientNotFoundException> cNFExceptionHandler = (e, ctx) -> {
		ctx.status(404);
		
		ExceptionDTO stat = new ExceptionDTO();
		stat.setMessage(e.getMessage());
		
		ctx.json(stat);
	};
	
	private ExceptionHandler<InvalidInputException> invalidInputExceptionHandler = (e, ctx) -> {
		ctx.status(400);
		
		ExceptionDTO stat = new ExceptionDTO();
		stat.setMessage(e.getMessage());
		
		ctx.json(stat);
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.exception(DBException.class, dbExceptionHandler);
		app.exception(ClientNotFoundException.class, cNFExceptionHandler);
		app.exception(InvalidInputException.class, invalidInputExceptionHandler);
	}

}
