package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginByEmail() throws InterruptedException {
        List<WebElement> unameAndPass = driver.findElements(By.className("form-control"));
        Thread.sleep(2000);
        unameAndPass.get(2).sendKeys("sohel@gain.io");
        unameAndPass.get(3).sendKeys("SQAengineer");
        Thread.sleep(2000);
        List<WebElement> loginBtn = driver.findElements(By.className("btn-primary"));
        loginBtn.get(3).click();
    }

    public void loginByFacebook() throws InterruptedException {
        List <WebElement> facebook = driver.findElements(By.xpath("facebook-link-text"));
        Thread.sleep(5000);
        facebook.get(0).click();


    }
}
