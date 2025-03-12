package com.wipro.selenium_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class DemoQA extends BaseClass{


	@Test(priority = 1)
	@Parameters({"browser"})
	void openPage(String browser) {
		invokeBrowser(browser);
		driver.get("https://demoqa.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority=2)
	void dragAndDrop() {
        
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");

		driver.findElement(By.xpath("//a[@id='droppableExample-tab-revertable']")).click();

		WebElement drag = driver.findElement(By.xpath("//div[@id='revertable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='revertableDropContainer']//div[@id='droppable']"));

		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		act.dragAndDropBy(drag, 0, 0);

	}

	
	@Test(priority = 3)
	void dragXaxis() {
		driver.get("https://demoqa.com/dragabble");
		driver.findElement(By.xpath("//a[@id='draggableExample-tab-axisRestriction']")).click();

		WebElement drag = driver.findElement(By.xpath("//div[@id='dragBox']"));
		

		Actions act = new Actions(driver);
		act.dragAndDropBy(drag, 20, 10).perform();
	}
}
////min slider
//WebElement min_slide =driver.findElement(By.xpath("//div[@id='green']//span"));
//System.out.println("location of the min slider :"+min_slide.getLocation());//(178,115)
//
//
//act.dragAndDropBy(min_slide, 50, 40).perform();
//System.out.println("location of the min slider :"+min_slide.getLocation());
