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

public class TestXpathNavigation {
    private WebDriver driver;
    private String url="https://www.automationanywhere.com/";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\techademy\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test(priority = 1)
    public void testProductsLink() {
        clickAndVerifyLink("Products");
        Assert.assertEquals(clickAndVerifyLink("Products"), expectedUrl("Products"));
    }

    @Test(priority = 2)
    public void testSolutionsLink() {
        clickAndVerifyLink("Solutions");
        Assert.assertEquals(clickAndVerifyLink("Solutions"), expectedUrl("Solutions"));
    }

    @Test(priority = 3)
    public void testResourcesLink() {
        clickAndVerifyLink("Resources");
        Assert.assertEquals(clickAndVerifyLink("Resources"), expectedUrl("Resources"));
    }

    @Test(priority = 4)
    public void testBeyondRPALink() {
        clickAndVerifyLink("Beyond RPA");
        Assert.assertTrue(clickAndVerifyLink("Beyond RPA").contains("rpa"));
    }

    @Test(priority = 5)
    public void testCompanyLink() {
        clickAndVerifyLink("Company");
        Assert.assertTrue(clickAndVerifyLink("Company").contains("company"));
    }

    private String clickAndVerifyLink(String linkText) {
        WebElement link = driver.findElement(By.xpath("//a[contains(text(), '" + linkText + "')]"));
        Assert.assertTrue(link.isDisplayed(), "Link '" + linkText + "' is not present.");
        link.click();
        String currentUrl=driver.getCurrentUrl();
        driver.navigate().back();
        return currentUrl;
    }

    private String expectedUrl(String linkText) {
        return url + linkText.toLowerCase();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
