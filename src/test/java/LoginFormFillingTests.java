
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormFillingTests extends TestBase {

    @Test(priority = 1)
    public void testWrongPassword() {
        wh.doLogin(username, password + "999");
        assertLoginError();
    }

    @Test(priority = 2)
    public void testWrongLogin() {
        wh.pageReload();
        wh.doLogin(username + "999", password);
        assertLoginError();
    }

    public void assertLoginError() {
        Assert.assertFalse(wh.findWebElements(By.id("error")).isEmpty());
    }

}
