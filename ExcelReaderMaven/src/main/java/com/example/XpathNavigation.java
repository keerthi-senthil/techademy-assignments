package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XpathNavigation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\techademy\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        clickAndVerifyLink(driver, "Products");
        clickAndVerifyLink(driver, "Solutions");
        clickAndVerifyLink(driver, "Resources");
        clickAndVerifyLink(driver, "Beyond RPA");
        clickAndVerifyLink(driver, "Company");
        driver.quit();
    }

    private static void clickAndVerifyLink(WebDriver driver, String linkText) {
        WebElement link = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));
        if (link.isDisplayed()) {
            System.out.println("Link '" + linkText + "' is present in home page.");
            link.click();
            System.out.println("Navigated to: " + driver.getCurrentUrl());
            driver.navigate().back();
        } else {
            System.out.println("Link '" + linkText + "' is not present in home page.");
        }
    }
}

