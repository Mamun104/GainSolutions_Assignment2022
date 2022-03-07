package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateAccount {
    public WebDriver driver;
    WebDriverWait wait;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doCreate() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement actionAccount = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("accounts-actions-dropdown"))));
        actionAccount.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement btnCreate = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Add account')]"))));
        btnCreate.click();
        Thread.sleep(3000);
        List<WebElement> fillUp = driver.findElements(By.className("form-control"));

        Faker faker = new Faker();
        String name = faker.name().firstName() + " " + faker.name().lastName();
        fillUp.get(2).sendKeys(name);
        String randomEmail = faker.name().firstName().toLowerCase() + faker.name().lastName().toLowerCase() + "@mailinator.com";
        fillUp.get(3).sendKeys(randomEmail);
        fillUp.get(5).sendKeys("43646639 ");
        fillUp.get(6).sendKeys("221B Baker St");
        fillUp.get(7).sendKeys("1200");
        fillUp.get(8).sendKeys("Dhaka");
        fillUp.get(9).sendKeys("BD");
        fillUp.get(10).click();
        Thread.sleep(5000);
        List<WebElement> agent = driver.findElements(By.className("js-filter-item"));
        agent.get(0).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        WebElement btnAdd = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Add account')]"))));
        btnAdd.click();

    }
}
