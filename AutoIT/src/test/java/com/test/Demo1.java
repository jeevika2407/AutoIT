package com.test;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo1 {
    public static void main(String[] args) throws Exception {
       ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://pdf2doc.com/"); 

        WebElement file = driver.findElement(By.xpath("(//span[@class='button__text'])[1]"));
        file.click();

//        Runtime.getRuntime().exec("C:\\Users\\kirub\\Downloads\\new2.exe");
//       driver.quit();
 
    	Thread.sleep(2000);
    	Robot r=new Robot();
    	StringSelection str=new StringSelection("C:\\Users\\kirub\\Downloads\\maven.pdf");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_V);
    	
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_V);
    	
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
  
   
    }
}
