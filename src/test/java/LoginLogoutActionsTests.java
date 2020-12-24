
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutActionsTests extends TestBase {

    @Test(priority = 1)
    public void testLoginSuccess() {
        wh.pageReload();
        wh.doLogin(username, password);
        Assert.assertFalse(wh.findWebElements(By.className("support-button")).isEmpty());
    }

    @Test(priority = 2)
    public void testLogoutSuccess() {
        wh.click(By.id("userName"));
        wh.findWebElements(By.cssSelector("ul.list-unstyled>li")).get(7).click();
        Assert.assertTrue(wh.findWebElements(By.className("login center-block")).isEmpty());
    }
}
