package com.test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class PdfReader {
public static void main(String args[]) {
	String file=System.getProperty("user.dir")+File.separator+"downloads";
	ChromeOptions op=new ChromeOptions();
	Map<String,Object> pre=new HashMap<>();
	pre.put("plugins.always_open_pdf_externally",true);
	pre.put("download.default_directory",file);
	op.setExperimentalOption("prefs",pre);
	WebDriver driver=new ChromeDriver(op);
	driver.manage().window().maximize();
	driver.get("https://freetestdata.com/document-files/pdf/#google_vignette");
	WebElement link=driver.findElement(By.xpath("(//a[@class=\"elementor-button elementor-button-link elementor-size-sm\"])[1]"));
	link.click();
	File dwn=new File(file+"/Free_Test_Data_100KB_PDF.pdf");
	if(dwn.exists()) {
		System.out.println("File is downloaded!");
	}
	else{
		System.out.println("File is not downloaded");
	}
	PDDocument doc=null;
	try {
		doc=Loader.loadPDF(dwn);
		PDFTextStripper pdf=new PDFTextStripper();
		String text=pdf.getText(doc);
		doc.close();
		System.out.println(text);
	}catch (IOException e) {
		System.out.println(e.getMessage());
	}
	driver.quit();
	
}
}