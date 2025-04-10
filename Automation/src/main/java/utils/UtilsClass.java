package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UtilsClass {

    public static void writeText(WebDriver driver, By locator, String text) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

     // this can be improve to reduce code on BenefitsDashboard
    /*
    public static boolean verifyRecords(WebDriver driver, String firstName, String lastName, String dependants) {
        List<WebElement> rows = driver.findElements(By.cssSelector("#employeesTable tbody tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.size() >= 2) {
                String cellFirstName = cells.get(1).getText().trim();
                String cellLastName = cells.get(2).getText().trim();
                String cellDependants = cells.get(3).getText().trim();
                if (cellFirstName.equalsIgnoreCase(firstName)  && cellLastName.equals(lastName ) && cellDependants.equals(dependants)) {
                    return true;
                }
            }
        }
        return false;
    }*/
}
