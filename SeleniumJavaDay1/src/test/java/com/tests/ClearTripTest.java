package com.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClearTripTest {

	@Test
	public void triptest() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		WebElement from = driver.findElement(By.xpath("//*[@id='FromTag']"));
		
		Actions act =new Actions(driver);
		act.keyDown(from,Keys.SHIFT).sendKeys("h").perform();
		Thread.sleep(2000);
		act.keyUp(Keys.SHIFT);
		Thread.sleep(2000);
		act.sendKeys("yd").perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		String city = from.getAttribute("value");
		Assert.assertEquals(city, "HYD");
		
		WebElement To = driver.findElement(By.xpath("//*[@id='ToTag']')"));
		To.sendKeys("ban");
		WebElement ul = driver.findElement(By.xpath("//*[@id='ui-id-2']"));
		
		List<WebElement> list =ul.findElements(By.tagName("li"));
		Assert.assertEquals(list.size(), 10);
		for(WebElement e:list){
			String ci=e.getText();
			if(ci.contains("BKK")){
				e.click();
				break;
			}
		}
		
	}
}
//https://demowebshop.tricentis.com/