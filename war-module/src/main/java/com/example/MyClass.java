package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyClass {

	@Autowired
	private OtherBean bean;

	public String getString() {return "A new String: " + bean.test();}
}
