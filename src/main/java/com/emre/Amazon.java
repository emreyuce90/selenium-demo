package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        final String url = "https://www.amazon.com.tr/";
        driver.get(url);
        //hover edilecek element
        WebElement element = driver.findElement(By.id("nav-link-accountList"));
//Mouse eventi oluştur
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span"));
        button.click();
        driver.quit();
    }
}
