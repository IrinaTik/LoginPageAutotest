
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class TestBase {

    protected static final WebHelper wh = new WebHelper();

    protected static String username = "tester";
    protected static String password = "K35G3U";

    @AfterMethod
    public void doReloadPage() {
        wh.pageReload();
    }

    @AfterSuite
    public void tearDown() {
        wh.stop();
    }

}
