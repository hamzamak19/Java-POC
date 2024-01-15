package nisum.selenium.pages;

import nisum.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    private final By firstnameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By clickHereToLoginLink = By.className("showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginBtn = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");

    private final By alternateCountryDropDown = By.id("select2-billing_country-container");
    private final By alternateStateDropDown = By.id("select2-billing_state-container");

    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    private final By productName = By.cssSelector("td[class='product-name']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        driver.findElement(firstnameFld).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(lastNameFld).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String addressLineOne) {
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(addressLineOne);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postCode) {
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(postCode);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(email);
        return this;
    }

    public CheckoutPage placeOrder() {
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(successNotice).getText();
    }

    public CheckoutPage clickHereToLoginLink(){
        driver.findElement(clickHereToLoginLink).click();
        return this;
    }

    public CheckoutPage enterUserName(String username){
        driver.findElement(usernameFld).sendKeys(username);
        return this;
    }

    public CheckoutPage enterPassword(String password){
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public CheckoutPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return this;
    }

    public CheckoutPage login(String userName, String password){
        return enterUserName(userName).
                enterPassword(password).
                clickLoginBtn();
    }
}
