package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JoinWithUs {

    public WebDriver driver;
    WebDriverWait wait;

    public JoinWithUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void joinByEmail() throws InterruptedException {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String randomEmail = firstName.toLowerCase() + "@mailinator.com";

        List<WebElement> btnJoin = driver.findElements(By.className("sign-dropdown"));
        Thread.sleep(2500);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJoin.get(0)).click().build().perform();
        WebElement emailLink = driver.findElement(By.className("email-link-text"));
        actions.moveToElement(emailLink).click().build().perform();

        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("name"))));
        username.sendKeys(firstName);
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("email"))));
        email.sendKeys(randomEmail);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("159159159");
        WebElement confirm_Password = driver.findElement(By.id("confirm_password"));
        confirm_Password.sendKeys("159159159");
        WebElement checkmark = driver.findElement(By.className("checkmark"));
        checkmark.click();

        List<WebElement> btnRegister = driver.findElements(By.className("btn-primary"));
        btnRegister.get(0).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        String text = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("activate-account-header")))).getText();
        Assert.assertTrue(text.contains("Activate your account"));

    }

    public void joinByFacebook() throws InterruptedException {

        List<WebElement> btnJoin = driver.findElements(By.className("sign-dropdown"));
        Thread.sleep(2500);
        Actions actions = new Actions(driver);
        actions.moveToElement(btnJoin.get(0)).click().build().perform();
        Thread.sleep(3000);
        List<WebElement> fbBtn = driver.findElements(By.className("facebook-link-text"));
        fbBtn.get(0).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement checkMark = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("checkmark"))));
        checkMark.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement registerBtn = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Register')]"))));
        registerBtn.click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(150));
        String text = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("fsl")))).getText();
        Assert.assertTrue(text.contains("URL blocked"));



    }
}
