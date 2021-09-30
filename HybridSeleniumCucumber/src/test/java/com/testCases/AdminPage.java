package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClass.Library;
import com.pages.LoginPage;
import com.seleniumReusableFunction.SeleniumUtilities;

public class AdminPage extends Library {
	
	@BeforeTest
    public void stratUp() {
        launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void login() {
        LoginPage lpage=new LoginPage(driver);
        lpage.login("Admin", "admin123");
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("menu_admin_UserManagement")).click();
        driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userName\"]")).sendKeys("Aatmaram");
		WebElement drop1=driver.findElement(By.xpath("//*[@id=\"searchSystemUser_userType\"]"));
		 Select user = new Select(drop1);  
		user.selectByVisibleText("ESS");
		
		WebElement name=driver.findElement(By.xpath("//*[contains(@id,'searchSystemUser_employeeName_empName')]"));
		name.sendKeys("Alice Duval");
		 
		WebElement drop2=driver.findElement(By.xpath("//*[@id=\"searchSystemUser_status\"]"));
		 Select SELE = new Select(drop2);  
		SELE.selectByVisibleText("Enabled");

    }
    @AfterClass
    public void close() throws IOException {
        SeleniumUtilities sUti = new SeleniumUtilities(driver);
        sUti.to_take_screenshot("src\\test\\resources\\screenshots\\orangeHRMadmin.png");
        //sUti.to_take_screenshot("C:\\Users\\samik_000\\eclipse-workspace\\LTI\\HybridSeleniumCucumber\\src\\test\\resources\\screenshots\\orangeHRMLogi.png");

        quit();

    }

}
