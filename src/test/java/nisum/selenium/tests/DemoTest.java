package nisum.selenium.tests;

import nisum.selenium.base.BaseTest;
import nisum.selenium.pages.CartPage;
import nisum.selenium.pages.CheckoutPage;
import nisum.selenium.pages.HomePage;
import nisum.selenium.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTest extends BaseTest {
    @Test
    public void EndToEndWithGuestUser() throws InterruptedException {

       /* HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");*/

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        // Todo:: Constants will be used in future
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com").
                placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void EndToEndWithLoginUser() throws InterruptedException {

        HomePage homePage = new HomePage(driver).load();
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickHereToLoginLink();
        Thread.sleep(3000);
        checkoutPage.
                login("demomaki", "demomaki").
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com").
                placeOrder();

        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
}
