package com.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoQa_sendKeys {
    public static void main(String[] args) throws InterruptedException {
        // Set file path
        String filePath = "C:\\Users\\kirub\\Downloads\\maven.txt";

        // Setup ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the DemoQA upload/download page
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        // Upload the file using sendKeys
        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        uploadElement.sendKeys(filePath);

        // Wait for upload to process
        Thread.sleep(2000);

        // Download a sample file
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        // Optional: Check uploaded file name
        WebElement uploadedPath = driver.findElement(By.id("uploadedFilePath"));
        String uploadedFile = uploadedPath.getText();
        System.out.println("Uploaded File: " + uploadedFile);

        Thread.sleep(3000);
        driver.quit();
    }
}
