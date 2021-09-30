package com.seleniumReusableFunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseClass.Library;

public class SeleniumUtilities extends Library {

	public SeleniumUtilities(WebDriver driver) {
        this.driver=driver;

    }
    public void to_take_screenshot(String path) {
        TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File(path));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void getTitle() {

        System.out.println(driver.getTitle());

    }
    public void Explicitlywait(String Locator) {
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Locator))));

    }
    public void dropdown(WebElement element,String selectedvalue) {
        Select select = new Select(element); 
        select.selectByVisibleText(selectedvalue);

    }
    public void quit() {
        driver.close();

    }
	
}
