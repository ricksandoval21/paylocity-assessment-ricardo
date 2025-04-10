package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilsClass;
import java.time.Duration;
import java.util.List;

public class BenefitsDashboard {

    private final WebDriver driver;
    WebDriverWait wait;
    private final By addEmployeeButton = By.id("add");
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By dependants = By.id("dependants");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By updateIcon = By.cssSelector("td:nth-child(9) > i.fas.fa-edit");
    private final By updateButton = By.id("updateEmployee");
    private final By deleteIcon = By.cssSelector(".fa-times");
    private final By deleteButton = By.id("deleteEmployee");
    private final By benefitsTitle = By.xpath("/html/body/header/nav/div/a");
    private final By benefitsTable = By.id("employeesTable");
    private final By logOutLink = By.xpath("//a[text()='Log Out']");
    private final By loginFormContainer = By.className("login-form-container");

    public BenefitsDashboard(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddEmployeeButton() {
        driver.findElement(addEmployeeButton).click();
    }

    public void updateEmployee(String firstName, String lastName, String dependants) {

        waitForBenefitsTable(driver);
        WebElement table = driver.findElement(benefitsTable);
        scrollTableToBottom(table);
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Total row founded: " + rows.size());

        for (WebElement row : rows) {
            System.out.println("Analysis of row" + row.getText());
            if (row.getText().contains(firstName) &&
                    row.getText().contains(lastName) &&
                    row.getText().contains(dependants)) {

                WebElement updateIconRow = row.findElement(updateIcon);
                updateIconRow.click();
                waitForBenefitsTable(driver);

                UtilsClass.writeText(driver, this.firstName, "This");
                UtilsClass.writeText(driver, this.lastName, "An updated name");
                UtilsClass.writeText(driver, this.dependants, "15");
                driver.findElement(updateButton).click();

                return;
            }
        }
        throw new NoSuchElementException("Employee not found: " + firstName + ", " + lastName + ", " + dependants);
    }

    public void enterFirstname(String username) {
        UtilsClass.writeText(driver, firstName, username);
    }

    public void enterLastname(String username) {
        UtilsClass.writeText(driver, lastName, username);
    }

    public void enterDependents(String username) {
        UtilsClass.writeText(driver, dependants, username);
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public void waitForBenefitsTitle(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(benefitsTitle));
    }

    public void waitForBenefitsTable(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(benefitsTable));
    }

    public void deleteEmployee(String firstName, String lastName, String dependents) {
        waitForBenefitsTable(driver);
        WebElement table = driver.findElement(benefitsTable);
        scrollTableToBottom(table);
        WebElement tbody = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Total row founded: " + rows.size());

        for (WebElement row : rows) {
            System.out.println("Analysis of row" + row.getText());
            if (row.getText().contains(firstName) &&
                    row.getText().contains(lastName) &&
                    row.getText().contains(dependents)) {

                WebElement deleteIconRow = row.findElement(deleteIcon);
                deleteIconRow.click();
                waitForBenefitsTable(driver);
                driver.findElement(deleteButton).click();
                return;
            }
        }
        throw new NoSuchElementException("Employee not found: " + firstName + ", " + lastName + ", " + dependents);
    }

    public void scrollTableToBottom(WebElement table) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollHeight", table);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void logOutFromPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(logOutLink));
        driver.findElement(logOutLink).click();
        WebElement loginForm = wait.until(ExpectedConditions.presenceOfElementLocated(loginFormContainer));
    }

    //TODO: We can more validation for the table to get elements, counts, etc.
}
