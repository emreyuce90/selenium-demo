package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        final String url = "https://www.selenium.dev/selenium/web/web-form.html";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);


        WebElement text = driver.findElement(By.id("my-text-id"));
        WebElement password = driver.findElement(By.name("my-password"));
        WebElement textarea = driver.findElement(By.name("my-textarea"));
        WebElement submit = driver.findElement(By.cssSelector("button.btn.btn-outline-primary.mt-3"));
WebElement we = driver.findElement(By.linkText(""));

        text.sendKeys("Emre");
        password.sendKeys("Emre123*");
        textarea.sendKeys("Lorem ipsum dolor sit amet");
        submit.click();

        String pageSource = driver.getPageSource();
        boolean formSubmitted = pageSource.contains("Form submitted");
        if(formSubmitted) {
            System.out.println("Form submitted");
        }else {
            System.out.println("Form not submitted");
        }

    }
}
