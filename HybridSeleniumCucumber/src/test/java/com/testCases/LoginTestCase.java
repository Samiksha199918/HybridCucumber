package com.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClass.Library;
import com.pages.LoginPage;
import com.seleniumReusableFunction.SeleniumUtilities;

public class LoginTestCase extends Library{

	@BeforeTest
    public void stratUp() {
        launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void login() {
        LoginPage lpage=new LoginPage(driver);
        lpage.login("Admin", "admin123");

    }
    @AfterClass
    public void close() throws IOException {
        SeleniumUtilities sUti = new SeleniumUtilities(driver);
        sUti.to_take_screenshot("src\\test\\resources\\screenshots\\orangeHRMLogin.png");
        //sUti.to_take_screenshot("C:\\Users\\samik_000\\eclipse-workspace\\LTI\\HybridSeleniumCucumber\\src\\test\\resources\\screenshots\\orangeHRMLogi.png");

        quit();

    }
	
}
