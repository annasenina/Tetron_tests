package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CallBackOrderFormPage;
import pages.MainPage;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;


public class CallbackFormTests extends TestBase{

    final MainPage mainPage = new MainPage();
    final CallBackOrderFormPage callBackForm = new CallBackOrderFormPage();

    @Test
    @Tag("web")
    @Feature("Форма \"Заказать звонок\"")
    @AllureId("3154")
    @DisplayName("При нажатии на кнопку \"Заказать звонок\" открывается форма \"Заказать звонок\"")
    void canOpenCallbackFormTest()
    {
        mainPage.openMainPage();
        mainPage.clickOrderCallBackButton();

        callBackForm.checkFormOpened();
        callBackForm.formHasNameAndPhoneField();
    }

    @Test
    @Tag("web")
    @AllureId("3158")
    @DisplayName("Форму \"Заказать звонок\" можно закрыть")
    void canCloseCallbackFormTest() {
        mainPage.openMainPage();
        mainPage.clickOrderCallBackButton();

        callBackForm.clickCloseForm();
        callBackForm.checkFormClosed();
    }

    @Test
    @Tag("web")
    @AllureId("3155")
    @DisplayName("Поле \"Ваше имя\" обязательно к заполнению")
    void nameMustBeCompletedTest() {
        mainPage.openMainPage();
        mainPage.clickOrderCallBackButton();

        callBackForm.fillPhone("1234567890");
        callBackForm.clickSubmitButton();

        callBackForm.checkNameFieldIsRed();
    }

    @Test
    @Tag("web")
    @AllureId("3156")
    @DisplayName("Поле \"Телефон\" обязательно к заполнению")
    void phoneMustBeCompletedTest() {
        mainPage.openMainPage();
        mainPage.clickOrderCallBackButton();

        callBackForm.fillName("Иванов Иван");
        callBackForm.clickSubmitButton();

        callBackForm.checkPhoneFieldIsRed();
    }

    @Test
    @Tag("web")
    @AllureId("3157")
    @DisplayName("Можно отправить заявку на обратный звонок")
    void userCanSendOrderToCallBackTest() {
        mainPage.openMainPage();
        mainPage.clickOrderCallBackButton();

        callBackForm.fillPhone("1234567890");
        callBackForm.fillName("Иванов Иван");

        callBackForm.clickSubmitButton();
        callBackForm.checkFormClosed();

        sleep(5000);

        step ("ToDo Проверяем в БД, что данные пользователя сохранились");

    }

}


