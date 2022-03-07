package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginByEmail() throws InterruptedException {
        List<WebElement> userNameAndPassword = driver.findElements(By.className("form-control"));
        Thread.sleep(2000);
        userNameAndPassword.get(2).sendKeys("sohel@gain.io");
        userNameAndPassword.get(3).sendKeys("SQAengineer");
        Thread.sleep(2000);
        List<WebElement> loginBtn = driver.findElements(By.className("btn-primary"));
        loginBtn.get(3).click();
    }

}