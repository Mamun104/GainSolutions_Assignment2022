package TestRunner;

import Pages.CreateAccount;
import Pages.LoginPage;
import Setup.SetUp;
import org.testng.annotations.Test;

public class AccountTestRunner extends SetUp {

    CreateAccount createAccount;
    LoginPage loginPage;

    @Test
    public void accountCreate() throws InterruptedException {
        driver.get("https://partnerforsqa.dev.uniteliving.com/login");
        loginPage = new LoginPage(driver);
        loginPage.loginByEmail();
        driver.get("https://partnerforsqa.dev.uniteliving.com/dtms/accounts");
        createAccount = new CreateAccount(driver);
        createAccount.doCreate();
    }

}
