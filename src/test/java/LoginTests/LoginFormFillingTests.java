package LoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormFillingTests extends TestBase {

    private static final String AUTH_ERROR_MESSAGE = "Неверное имя пользователя или пароль";

    @Test(priority = 1)
    public void testPageReady() {
        Assert.assertTrue(loginPage.pageLoaded());
    }

    @Test(priority = 2)
    public void testWrongPassword() {
        loginPage.ordinaryLogin(username, password + "999");
        assertFailedLogin();
    }

    @Test(priority = 3)
    public void testWrongLogin() {
        loginPage.reload();
        // где-то тут надо проверять, что ничего не осталось в полях
        loginPage.ordinaryLogin(username + "999", password);
        assertFailedLogin();
    }

    private void assertFailedLogin() {
        loginPage.waitForAuthError();
        Assert.assertFalse(loginPage.authErrorExists());
        Assert.assertEquals(loginPage.getAuthErrorText(), AUTH_ERROR_MESSAGE);
    }
}
