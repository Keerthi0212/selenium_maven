package com.wipro.selenium_maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class Globalsqa extends BaseClass {
	
	@Test
	void slido() {
		invokeBrowser("edge");
		driver.get("https://www.globalsqa.com/demo-site/sliders/#Color%20Picker");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,300)");

		
		WebElement frame = driver.findElement(By.xpath("//*[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frame);
		//max slider
		WebElement max_slide =driver.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	    System.out.println("location of the max slider :"+max_slide.getLocation());//(x,y)//(314,71)
	    
	    Actions act = new Actions(driver);
	    act.dragAndDropBy(max_slide, -200, 71).perform();
	    System.out.println("location of the max slider :"+max_slide.getLocation());  
	    
	    //String selectedColor = driver.findElement(By.id("swatch")).getCssValue("background-color");
	    Color selectedColor = Color.fromString(driver.findElement(By.id("swatch")).getCssValue("background-color"));
	    System.out.println("selected color is: "+selectedColor);
	    
	}

}
