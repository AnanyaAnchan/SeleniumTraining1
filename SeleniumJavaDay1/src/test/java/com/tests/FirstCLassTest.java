package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class FirstCLassTest {
	@Test
	public void FirstClass() {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.hdfcbank.com/");
	Actions Act = new Actions(driver);
	Act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']"))).perform();
	Act.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']"))).perform();
	driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")).click();
	Assert.assertTrue(driver.getCurrentUrl().contains("redit"));
	}
}

//https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx

