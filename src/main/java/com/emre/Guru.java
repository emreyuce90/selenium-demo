package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru {
    public static void main(String[] args) {
        final String url="https://demo.guru99.com/test/login.html";
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get(url);
        driver.findElement(By.id("email")).sendKeys("guru99@guru99.com");
        driver.findElement(By.id("passwd")).sendKeys("guru99");
        driver.findElement(By.name("SubmitLogin")).click();
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://demo.guru99.com/test/success.html")){
            System.out.println("Successfully logged in");
        }else{
            System.out.println("Login failed");
        }
        driver.quit();
    }
}
