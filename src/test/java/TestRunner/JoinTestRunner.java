package TestRunner;

import Pages.JoinWithUs;
import Setup.SetUp;
import org.testng.annotations.Test;

public class JoinTestRunner extends SetUp {

    JoinWithUs joinWithUs;

    @Test
    public void joinByEmailTest() throws InterruptedException {

        driver.get("https://partnerforsqa.dev.uniteliving.com/login");
        joinWithUs = new JoinWithUs(driver);
        joinWithUs.joinByEmail();
    }

    @Test
    public void joinByFacebookTest() throws InterruptedException {
        driver.get("https://partnerforsqa.dev.uniteliving.com/login");
        joinWithUs = new JoinWithUs(driver);
        joinWithUs.joinByFacebook();


    }
}
