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

public class Recruitment extends Library{
	
	@BeforeTest
    public void stratUp() {
        launchApplication("chrome","https://opensource-demo.orangehrmlive.com/");

    }
    @Test
    public void login() {
        LoginPage lpage=new LoginPage(driver);
        lpage.login("Admin", "admin123");
        driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
        driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
        WebElement drop1=driver.findElement(By.id("candidateSearch_jobTitle"));
        Select user = new Select(drop1);  
		user.selectByVisibleText("Account Assistant");
        

    }
    @AfterClass
    public void close() throws IOException {
        SeleniumUtilities sUti = new SeleniumUtilities(driver);
        sUti.to_take_screenshot("src\\test\\resources\\screenshots\\orangeHRMLogin.png");
        //sUti.to_take_screenshot("C:\\Users\\samik_000\\eclipse-workspace\\LTI\\HybridSeleniumCucumber\\src\\test\\resources\\screenshots\\orangeHRMLogi.png");

        quit();

    }

}
