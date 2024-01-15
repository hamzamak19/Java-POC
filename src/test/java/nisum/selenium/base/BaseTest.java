package nisum.selenium.base;

import nisum.selenium.driverfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void startDriver() {
         /*DriverManager driverManager = new DriverManager();
         driver = driverManager.initializeDriver();*/

        // Both ways are correct above and below
        driver = new DriverManager().initializeDriver();

    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
