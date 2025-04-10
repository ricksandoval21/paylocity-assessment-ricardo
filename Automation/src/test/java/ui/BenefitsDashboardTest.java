package ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BenefitsDashboard;
import pages.Login;
import utils.DriverFactory;

public class BenefitsDashboardTest {
    private WebDriver driver;
    BenefitsDashboard benefitsDashboardPage;
    Login loginPage;

    @BeforeClass
    public void setup() {
        SoftAssert softAssert = new SoftAssert();
        driver = DriverFactory.createDriver();
        driver.get("https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login");
        benefitsDashboardPage = new BenefitsDashboard(driver);
        loginPage = new Login(driver);
        loginPage.enterUsername("TestUser741");
        loginPage.enterPassword("{1YsCHeW}@Oz");
        loginPage.clickLoginButton();
    }

    @Test
    public void addEmployee() {
        benefitsDashboardPage.waitForBenefitsTitle(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Benefits");
        benefitsDashboardPage.clickAddEmployeeButton();
        benefitsDashboardPage.enterFirstname("David");
        benefitsDashboardPage.enterLastname("Create");
        benefitsDashboardPage.enterDependents("3");
        benefitsDashboardPage.clickAddButton();
    }

    @Test
    public void updateEmployee() {
        benefitsDashboardPage.clickAddEmployeeButton();
        benefitsDashboardPage.enterFirstname("Paola");
        benefitsDashboardPage.enterLastname("Updating");
        benefitsDashboardPage.enterDependents("4");
        benefitsDashboardPage.clickAddButton();
        benefitsDashboardPage.updateEmployee("Paola", "Updating", "4");
    }

    @Test
    public void deleteEmployee() {
        String firstName = "Employee";
        String lastName = "ToDelete";
        String dependents = "10";
        benefitsDashboardPage.clickAddEmployeeButton();
        benefitsDashboardPage.enterFirstname(firstName);
        benefitsDashboardPage.enterLastname(lastName);
        benefitsDashboardPage.enterDependents(dependents);
        benefitsDashboardPage.clickAddButton();
        benefitsDashboardPage.deleteEmployee(firstName, lastName, dependents);
    }

    @AfterClass
    public void tearDown() {
        benefitsDashboardPage.logOutFromPage(driver);

        if (driver != null) {
            driver.quit();
        }
    }
}