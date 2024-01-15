package nisum.selenium.pages;

import nisum.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage load() {
        load("/");
        return this;
    }

    // Fluent Interface
    // Tight Coupling
    // This function is navigating to StorePage that's why store page object is returned
    public StorePage navigateToStoreUsingMenu() {
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }
}
