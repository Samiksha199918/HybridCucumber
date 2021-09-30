package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseClass.Library;
import com.pages.LoginPage;
import com.seleniumReusableFunction.SeleniumUtilities;

public class Time extends Library{
	@BeforeTest
    public void stratUp() {
        launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void login() {
        LoginPage lpage=new LoginPage(driver);
        lpage.login("Admin", "admin123");
        driver.findElement(By.id("menu_time_viewTimeModule")).click();
        driver.findElement(By.id("menu_time_Timesheets")).click();
        //driver.findElement(By.xpath("menu_time_viewEmployeeTimesheet")).click();
      
        WebElement name=driver.findElement(By.className("ac_input"));
        name.click();
        name.sendKeys("Cecil Bonaparte");
     
    }
    @AfterClass
    public void close() throws IOException {
        SeleniumUtilities sUti = new SeleniumUtilities(driver);
        sUti.to_take_screenshot("src\\test\\resources\\screenshots\\orangeHRMtime.png");
        //sUti.to_take_screenshot("C:\\Users\\samik_000\\eclipse-workspace\\LTI\\HybridSeleniumCucumber\\src\\test\\resources\\screenshots\\orangeHRMLogi.png");

       // quit();

    }

}
