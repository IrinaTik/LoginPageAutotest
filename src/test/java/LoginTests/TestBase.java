package LoginTests;

import Helpers.WebHelper;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.annotations.AfterSuite;

public class TestBase {

    protected static final WebHelper wh = new WebHelper();

    protected static String username = "tester";
    protected static String password = "K35G3U";

    LoginPage loginPage = new LoginPage(wh);
    ProfilePage profilePage = new ProfilePage(wh);

    @AfterSuite
    public void tearDown() {
        wh.stop();
    }

}
