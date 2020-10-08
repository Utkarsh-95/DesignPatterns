package com.utkarsh.java.dependencyinjection.injector;

import com.utkarsh.java.dependencyinjection.consumer.Consumer;
import com.utkarsh.java.dependencyinjection.consumer.MyDIApplication;
import com.utkarsh.java.dependencyinjection.service.SMSServiceImpl;

public class SMSServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}

}
