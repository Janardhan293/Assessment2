package TestCases;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import ObjectRepo.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.Common_Functions;

public class Navigate  extends Common_Functions {

    WebDriver driver = null;

    Homepage homepage = null;

    @BeforeClass
    public void launchBrowser() throws IOException {
        driver = browserLaunch();
        homepage = new Homepage(driver);
    }

    @Test(priority = 1)
    public void signIn() throws InterruptedException
    {
        click(homepage.getBestSellers());
        click(homepage.getItem());
        boolean a = homepage.getBuyNow().isDisplayed();
        if(a)
        {
            System.out.println("BuyNow button is displayed");
        }
        else
        {
            System.out.println("BuyNow button is not displayed");
        }
        click(homepage.getAddToCart());
        click(homepage.getCart());
        boolean b = homepage.getProceedToCheckout().isDisplayed();
        if(b)
        {
            System.out.println("proceedtocheckout button is displayed");
        }
        else
        {
            System.out.println("proceedtocheckout button is not displayed");
        }
    }

    @AfterClass
    public void teardown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.quit();
    }

}
