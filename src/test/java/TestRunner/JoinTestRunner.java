package TestRunner;

import Pages.JoinWithUs;
import Setup.SetUp;
import org.testng.annotations.Test;

public class JoinTestRunner extends SetUp {

    JoinWithUs joinWithUs;

    @Test
    public void createAccountByEmailTest(){

        driver.get("https://partnerforsqa.dev.uniteliving.com/dtms/accounts");

        joinWithUs = new JoinWithUs(driver);
        joinWithUs.createAccountByEmail();
    }
}
