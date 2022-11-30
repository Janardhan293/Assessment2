package TestCases;

import ObjectRepo.Homepage;
import Utilities.Common_Functions;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
public class CheckoutTests extends Common_Functions {

    Logger logger = Logger.getLogger(CheckoutTests.class.getName());
    WebDriver driver = null;
    Homepage homepage = null;
    @BeforeClass
    public void launchBrowser() throws IOException {
        driver = browserLaunch();
        homepage = new Homepage(driver);
        BasicConfigurator.configure();
        logger.info("Browser launched successfully");
    }
    @Test(priority = 1)
    public void navigate() throws InterruptedException {
        click(homepage.getBestSellers());
        Thread.sleep(2000);
        click(homepage.getItem());
        logger.info("Bestseller opened Successfully");
    }
    @Test(dependsOnMethods = {"navigate"})
    public void buyNow() throws InterruptedException {
        Thread.sleep(2000);
        if(homepage.getBuyNow().isDisplayed()) {
            logger.info("BuyNow button is displayed");
        } else {
            logger.info("BuyNow button is not displayed");
        }
    }
    @Test(dependsOnMethods = {"navigate"})
    public void checkout() throws InterruptedException {
        click(homepage.getAddToCart());
        Thread.sleep(2000);
        click(homepage.getCart());
        Thread.sleep(2000);
        if(homepage.getProceedToCheckout().isDisplayed()) {
            logger.info("proceed-to-checkout button is displayed");
        } else {
            logger.info("proceed-to-checkout button is not displayed");
        }
    }
    @AfterClass
    public void teardown() {
        driver.quit();
        logger.info("successfully closed the browser");
    }
}
