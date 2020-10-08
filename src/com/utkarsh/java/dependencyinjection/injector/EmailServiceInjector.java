package com.utkarsh.java.dependencyinjection.injector;

import com.utkarsh.java.dependencyinjection.consumer.Consumer;
import com.utkarsh.java.dependencyinjection.consumer.MyDIApplication;
import com.utkarsh.java.dependencyinjection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		MyDIApplication app = new MyDIApplication();
		app.setService(new EmailServiceImpl());
		return app;
	}

}
