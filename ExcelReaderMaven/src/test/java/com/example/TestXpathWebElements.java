package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestXpathWebElements {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\techademy\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test(priority = 1)
    public void testAutomationAnywhereLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        Assert.assertTrue(logo.isDisplayed(), "Automation Anywhere logo is not present.");
    }

    @Test(priority = 2)
    public void testRequestDemoButton() {
        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(),'Request demo')]"));
        Assert.assertTrue(requestDemoButton.isDisplayed(), "Request Demo button is not present.");
        Assert.assertTrue(requestDemoButton.isEnabled(), "Request Demo button is not clickable.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
