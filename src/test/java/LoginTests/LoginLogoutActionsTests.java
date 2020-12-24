package LoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutActionsTests extends TestBase {

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage.reload();
        loginPage.ordinaryLogin(username, password);
        Assert.assertTrue(profilePage.pageLoaded());
    }

    @Test(priority = 2)
    public void testLogoutSuccess() {
        profilePage.expandUserMenu();
        profilePage.logout();
        Assert.assertTrue(loginPage.pageLoaded());
    }
}
