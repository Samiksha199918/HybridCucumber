package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClass.Library;
import com.pages.LoginPage;
import com.seleniumReusableFunction.SeleniumUtilities;

public class PIM extends Library{
	
	@BeforeTest
    public void stratUp() {
        launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void login() throws InterruptedException {
        LoginPage lpage=new LoginPage(driver);
        lpage.login("Admin", "admin123");
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        
        driver.findElement(By.xpath("//*[@id=\"empsearch_id\"]")).sendKeys("0002");
        WebElement drop1=driver.findElement(By.xpath("//*[@id=\"empsearch_employee_status\"]"));
		 Select user = new Select(drop1);  
		user.selectByVisibleText("Full-Time Permanent");
		WebElement drop2=driver.findElement(By.xpath("//*[@id=\"empsearch_termination\"]"));
		 Select user1 = new Select(drop2);  
		user1.selectByVisibleText("Current and Past Employees");
		 WebElement name=driver.findElement(By.className("ac_input"));
	        name.sendKeys("Odis Adalwin");
	       
		
		
        
    }
    @AfterClass
    public void close() throws IOException {
        SeleniumUtilities sUti = new SeleniumUtilities(driver);
        sUti.to_take_screenshot("src\\test\\resources\\screenshots\\orangeHRMPIM.png");
        //sUti.to_take_screenshot("C:\\Users\\samik_000\\eclipse-workspace\\LTI\\HybridSeleniumCucumber\\src\\test\\resources\\screenshots\\orangeHRMLogi.png");

      // quit();

    }

}
