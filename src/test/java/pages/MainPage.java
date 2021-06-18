package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step ("Открываем главную страницу")
    public void openMainPage() {
        open("");
    }

    @Step ("Нажимаем на кнопку \"Заказать звонок\"")
    public void clickOrderCallBackButton() {
        $(byAttribute("data-popup","js_orerd_popup")).click();
    }
}
