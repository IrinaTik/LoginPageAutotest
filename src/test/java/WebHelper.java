import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebHelper {

    private static WebDriver wd;
    private final static String URL = "https://gdcloud.ru/release-17/auth/login";

    public WebHelper() {
        System.setProperty("webdriver.chrome.driver", "C:\\Programs\\JetBrains\\JavaTools\\chromedriver.exe");
        wd = new ChromeDriver();
        init();
    }

    public void init() {
        wd.get(URL);
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        wd.manage().window().maximize();
    }

    public void stop() {
        wd.quit();
    }

    public void doLogin(String login, String pass) {
        type(By.id("username"), login);
        type(By.id("password"), pass);
        click(By.id("login_button"));
    }

    public void type (By locator, String text) {
        wd.findElement(locator).sendKeys(text);
    }

    public void click (By locator) {
        wd.findElement(locator).click();
    }

    public void pageReload() {
        wd.navigate().refresh();
    }

    public List<WebElement> findWebElements(By locator) {
        return wd.findElements(locator);
    }
}
