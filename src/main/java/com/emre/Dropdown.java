package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) {
        final String url ="https://www.selenium.dev/selenium/web/web-form.html";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement dropdownList = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(dropdownList);
        dropdown.selectByValue("2");
    }
}
