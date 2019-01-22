package com.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AJAXTest {
@Test
public void ajax(){
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	WebElement from = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
	WebElement to = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_Label1']"));
	Actions Act = new Actions(driver);
	Act.dragAndDrop(from, to).perform();
	By ele = By.id("ctl00_ContentPlaceholder1_Label1");
	WebDriverWait wait =new WebDriverWait(driver, 50);
	wait.until(ExpectedConditions.invisibilityOfElementWithText(ele, "Drop a package here to check price"));
	String text= driver.findElement(ele).getText();
	assertTrue(text.contains("$"));
}
}
