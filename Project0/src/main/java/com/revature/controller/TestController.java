package com.revature.controller;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class TestController implements Controller{
	
	//this is a lambda expression that is basiccally implementing the handler functional interface
	//therefore this is a handler object definition, NOT A METHOD
	private Handler hello = (ctx) -> {
		ctx.html("<h1>Hello World!</h1>");
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/hello", hello); //for the 'GET /hello' endpoint, we will make use of hello handler object behavior.
	}

}
