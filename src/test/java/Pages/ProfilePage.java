package Pages;

import Helpers.WebHelper;
import org.openqa.selenium.By;

/*
Так как страница иногда спонтанно вылогинивается, не догружается (видно только верхнюю часть с меню),
то переход на страницу проверяла по наличию кнопки "сообщения" рядом с именем юзера.
 */

public class ProfilePage {

    private final int LOGOUT_MENU_INDEX = 7; // порядковый номер кнопки выхода в меню (считать с 0)

    private By supportButton = By.className("support-button");
    private By userShortInfo = By.id("userName");
    private By userMenu = By.cssSelector("ul.list-unstyled>li");

    private final WebHelper wh;

    public ProfilePage(WebHelper wh) {
        this.wh = wh;
    }

    public boolean pageLoaded() {
        return !wh.findWebElements(supportButton).isEmpty();
    }

    public void expandUserMenu() {
        wh.click(userShortInfo);
    }

    public void logout() {
        wh.findWebElements(userMenu).get(LOGOUT_MENU_INDEX).click();
    }

}
