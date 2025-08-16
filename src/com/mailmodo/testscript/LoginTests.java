package com.mailmodo.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mailmodo.generic.BaseClass;

@Listeners(com.mailmodo.generic.ListenerImplementation.class)
public class LoginTests extends BaseClass {
	@Test
	public void createTest() {
		Reporter.log("createTest", true);
	}
	
	@Test
	public void modifyTest() {
		Assert.fail();
		Reporter.log("modifyTest", true);
	}
}
