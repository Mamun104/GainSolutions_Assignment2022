package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoinWithUs {

    public WebDriver driver;
    WebDriverWait wait;

    public JoinWithUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAccountByEmail(){

        WebElement username = driver.findElement(By.id("name"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirm_Password = driver.findElement(By.id("confirm_password"));
        WebElement checkmark = driver.findElement(By.className("checkmark"));
        WebElement registerBtn = driver.findElement(By.tagName("button"));


        username.sendKeys("MD. MAMUNUR RASHID");
        email.sendKeys("mamunzaman340@gmail.com");
        password.sendKeys("159159159");
        confirm_Password.sendKeys("159159159");
        checkmark.click();
        registerBtn.click();

    }
}
