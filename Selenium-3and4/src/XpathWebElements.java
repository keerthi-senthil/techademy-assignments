import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XpathWebElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\techademy\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.automationanywhere.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }

        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(),'Request demo')]"));
        if (requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
            System.out.println("Request Demo button is present and clickable.");
        } else {
            System.out.println("Request Demo button is not present or not clickable.");
        }
        driver.quit();
    }
}
