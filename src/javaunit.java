import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

public class javaunit {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.calculator.net/");

        // Click on the "Mortgage Calculator" link using By.xpath
        driver.findElement(By.xpath("//a[text()='Mortgage Calculator']")).click();

        // Clear and enter the house price using By.cssSelector
        driver.findElement(By.cssSelector("#chouseprice")).clear();
        driver.findElement(By.cssSelector("#chouseprice")).sendKeys("120");

        // Clear and enter the down payment using By.tagName and By.cssSelector
        WebElement downPaymentInput = driver.findElement(By.tagName("input")).findElement(By.cssSelector("#cdownpayment"));
        downPaymentInput.clear();
        downPaymentInput.sendKeys("15");

        // Click the "Calculate" button using By.partialLinkText
        driver.findElement(By.partialLinkText("Calculate")).click();

        // Verify the monthly payment result using By.id
        WebElement monthlyPaymentResult = driver.findElement(By.id("cimonthlypayment"));
        String expectedMonthlyPayment = "0.64";
        assertEquals(expectedMonthlyPayment, monthlyPaymentResult.getAttribute("value"));

        driver.quit();
    }
}