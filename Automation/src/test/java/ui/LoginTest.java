package ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.DriverFactory;

public class LoginTest {
    private WebDriver driver;
    private Login loginPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.createDriver();
        driver.get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");
        loginPage = new Login(driver);
    }

    @Test
    public void testLogin() {
        loginPage.enterUsername("TestUser741");
        loginPage.enterPassword("{1YsCHeW}@Oz");
        loginPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Benefits");
    }

}
