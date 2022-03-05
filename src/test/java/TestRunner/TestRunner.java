package TestRunner;
import Pages.LoginPage;
import Setup.SetUp;
import org.testng.annotations.Test;

public class TestRunner extends SetUp {

    LoginPage loginPage;
    
    @Test
    public void loginByFacebookTest(){
        driver.get("https://partnerforsqa.dev.uniteliving.com/login");

        loginPage = new LoginPage(driver);
        loginPage.loginByEmail();

    }
}
