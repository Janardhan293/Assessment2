package ObjectRepo;
import Utilities.Common_Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    Common_Functions function = new Common_Functions();
    public Homepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Best Sellers")
    private WebElement bestSellers;
    @FindBy(className ="a-link-normal")
    private WebElement item;

    @FindBy(id = "buy-now-button")
    private WebElement buyNow;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;
    @FindBy(id = "nav-cart-count-container")
    private WebElement cart;
    @FindBy(name = "proceedToRetailCheckout")
    private WebElement proceedToCheckout;

    public WebElement getBestSellers() {
        return bestSellers;
    }
    public WebElement getItem() {
        return item;
    }
    public WebElement getBuyNow() {
        return buyNow;
    }
    public WebElement getAddToCart() {
        return addToCart;
    }
    public WebElement getCart() {
        return cart;
    }
    public WebElement getProceedToCheckout() {
        return proceedToCheckout;
    }
}

