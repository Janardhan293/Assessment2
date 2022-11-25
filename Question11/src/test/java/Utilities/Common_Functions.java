package Utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Common_Functions {

    WebDriver driver = null;

    public WebDriver browserLaunch() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        return driver;
    }
    public void sendKeys(WebElement element, String input) {
        element.sendKeys(input);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void linkText(WebDriver driver, String text) {
        driver.findElement(By.linkText(text)).click();
    }

}
