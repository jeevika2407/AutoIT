package com.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PdfDownload {
    public static void main(String[] args) throws InterruptedException {
    	String downloadFilePath=System.getProperty("user.dir")+File.separator+"downloads";
		ChromeOptions option =new ChromeOptions();
		Map<String,Object>prefs=new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory",downloadFilePath);
		option.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://freetestdata.com/document-files/pdf/");
		WebElement downloadLink=driver.findElement(By.xpath("//*[@class=\"elementor-button-text\"]"));
		downloadLink.click();
		
		Thread.sleep(5000);
		
		File downloadedFile=new File(downloadFilePath+ "/Free_Test_Data_100KB_PDF.pdf");
		
		if(downloadedFile.exists()) {
			System.out.println("file downloaded");
		}
		else {
			System.out.println("file not downloaded");
		}
		driver.quit();
	}

}
