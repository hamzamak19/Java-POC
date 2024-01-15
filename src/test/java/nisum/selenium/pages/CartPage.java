package nisum.selenium.pages;

import nisum.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public CheckoutPage checkout() {
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
