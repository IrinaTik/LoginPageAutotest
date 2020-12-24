package Pages;

import Helpers.WebHelper;
import org.openqa.selenium.By;

/*
Неясно, как и при каких условиях должна реагировать страница на нажатие кнопок:
"Войти (другая учетная запись)"
"Войти (текущая учетная запись)"
Чекбокс "запомнить" тоже не работает как я ожидала.
И так как я не понимаю принцип их работы, то проверять по ним ничего не буду
 */

public class LoginPage {

    private By userName = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.id("login_button");
    private By loginDomainButton = By.id("login_button_domain");
    private By loginCurrentButton = By.id("login_button_current");
    private By errorMessage = By.id("error");
    private By rememberCheckbox = By.id("remember");
    private By loginForm = By.id("login_form");

    private final WebHelper wh;

    public LoginPage(WebHelper wh) {
        this.wh = wh;
    }

    public void setCredentials(String username, String pass) {
        wh.type(userName, username);
        wh.type(password, pass);
    }

    public void clickOrdinaryLogin() {
        wh.click(loginButton);
    }

    public void clickDomainLogin() {
        wh.click(loginDomainButton);
    }

    public void clickCurrentLogin() {
        wh.click(loginCurrentButton);
    }

    public void ordinaryLogin(String username, String pass) {
        setCredentials(username, pass);
        clickOrdinaryLogin();
    }

    public void domainLogin(String username, String pass) {
        setCredentials(username, pass);
        clickDomainLogin();
    }

    public void currentLogin(String username, String pass) {
        setCredentials(username, pass);
        clickCurrentLogin();
    }

    public boolean pageLoaded() {
        return !wh.findWebElements(loginForm).isEmpty();
    }

    public void waitForAuthError() {
        wh.waitForElement(errorMessage);
    }

    public boolean authErrorExists() {
        return wh.findWebElements(errorMessage).isEmpty();
    }

    public String getAuthErrorText() {
        return wh.findWebElement(errorMessage).getText();
    }

    public void reload() {
        wh.pageReload();
    }
}
