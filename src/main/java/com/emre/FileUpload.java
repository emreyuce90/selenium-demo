package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        final String url ="https://demo.guru99.com/test/upload/";
        driver.get(url);
        //Dosya seç
WebElement fileUpload = driver.findElement(By.id("uploadfile_0"));
fileUpload.sendKeys("C:\\Pera\\selenium-demo\\src\\images\\indir.png");
        //Kullanım koşullarını kabul et

        //Submit

        driver.quit();
    }
}
