package com.emre;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hepsiburada {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            final String url = "https://www.hepsiburada.com/";
            driver.get(url);
            driver.manage().window().maximize();

            // Explicit Wait - Arama kutusunun yüklenmesini bekle
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By searchBoxLocator = By.xpath("//input[@type='search']");
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(searchBoxLocator));

            // Eğer element stale olursa, tekrar bul
            for (int i = 0; i < 3; i++) { // 3 defa tekrar deneyecek
                try {
                    searchBox = driver.findElement(searchBoxLocator);
                    searchBox.click();
                    searchBox.sendKeys("iPhone 15");
                    searchBox.sendKeys(Keys.ENTER);
                    break; // Başarılı olursa döngüden çık
                } catch (StaleElementReferenceException e) {
                    System.out.println("Element yenilendi, tekrar deneniyor...");
                    Thread.sleep(1000); // Kısa bir bekleme
                }
            }

            // Sonuçların yüklenmesini bekleyelim
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tarayıcıyı kapat
            driver.quit();
        }
    }
}
