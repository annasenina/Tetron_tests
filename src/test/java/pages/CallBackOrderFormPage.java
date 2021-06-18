package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

public class CallBackOrderFormPage {
    private final static SelenideElement
            callBackForm = $$(".content_popup").first(),
            closeButton = callBackForm.$$(".main_close").first(),
            submitButton = $(byText("Отправить")),
            nameField = $(byAttribute("name","form_text_1")),
            phoneField = $(byAttribute("name","form_text_3"));


    @Step("Открывается форма с заголовком \"Заказать звонок\"")
    public void checkFormOpened() {
        callBackForm.shouldBe(visible);
        callBackForm.shouldHave(text("Заказать звонок"));
    }

    @Step("На форме есть поля \"Ваше имя\" и \"Телефон\"")
    public void formHasNameAndPhoneField(){
        callBackForm.shouldHave(text("Ваше имя"));
        callBackForm.shouldHave(text("Телефон"));
    }

    @Step("Нажимаем на крестик")
    public void clickCloseForm() {
        closeButton.click();
    }

    @Step("Заполняем поле \"Ваше имя\"")
    public void fillName(String value) {
        nameField.setValue(value);
    }

    @Step("Проверяем, что поле \"Ваше имя\" подсветилось красным")
    public void checkNameFieldIsRed() {

        nameField.parent().shouldHave(text("Это поле заполнено неверно!"));
       // nameField.shouldHave(cssValue("border","#ff546b"));

    }

    @Step("Проверяем, что поле \"Телефон\" подсветилось красным")
    public void checkPhoneFieldIsRed() {
        phoneField.parent().shouldHave(text("Это поле заполнено неверно!"));
        //phoneField.shouldHave(cssValue("border","#ff546b"));
    }

    @Step("Заполняем поле \"Телефон\"")
    public void fillPhone(String value) {
        phoneField.setValue(value);
    }

    @Step("Форма закрывается")
    public void checkFormClosed() {
        callBackForm.shouldBe(hidden);
    }

    /*@Step("Форма закрывается")
    public void checkFormClosed() {
        callBackForm.shouldBe(hidden);
    }*/

    @Step("Нажимаем кнопку \"Отправить\"")
    public void clickSubmitButton() {
        submitButton.click();
    }
}
