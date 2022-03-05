package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginByEmail(){

        WebElement username = driver.findElement(By.className("form-control"));
        WebElement password = driver.findElement(By.className("form-control"));
        WebElement loginBtn = driver.findElement(By.tagName("button"));

        username.sendKeys("sohel@gain.io");
        password.sendKeys("SQAengineer");
        loginBtn.click();

    }
}
