package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;


public class CallbackFormTests extends TestBase{

    @Test
    @Tag("web")
    @AllureId("3154")
    @DisplayName("При нажатии на кнопку \"Заказать звонок\" открывается форма \"Заказать звонок\"")
    void canOpenCallbackFormTest()
    {
        step ("Открываем главную страницу", ()-> open(""));

        //$(".top_block").find(byText("Заказать звонок")).click();
        step ("Нажимаем на кнопку \"Заказать звонок\"", ()-> $(byAttribute("data-popup","js_orerd_popup")).click());

        step ("Открывается форма с заголовком \"Заказать звонок\"", ()-> {
                    $$(".content_popup").first().shouldBe(visible);
                    $$(".content_popup").first().shouldHave(text("Заказать звонок"));
                });
        step ("На форме есть поля \"Ваше имя\" и \"Телефон\"", ()-> {

                    $$(".content_popup").first().shouldHave(text("Ваше имя"));
                    $$(".content_popup").first().shouldHave(text("Телефон"));
        });
        sleep(5000);
    }

    @Test
    @Tag("web")
    //@AllureId("3154")
    @DisplayName("Форму \"Заказать звонок\" можно закрыть")
    void canCloseCallbackFormTest() {
        step ("Открываем главную страницу", ()-> open(""));

        step ("Нажимаем на кнопку \"Заказать звонок\"");

        step ("Нажимаем на крестик");

        step ("Форма закрывается");
    }

    @Test
    @Tag("web")
    //@AllureId("3154")
    @DisplayName("Поле \"Ваше имя\" обязательно к заполнению")
    void nameMustBeCompletedTest() {
        step ("Открываем главную страницу", ()-> open(""));

        step ("Нажимаем на кнопку \"Заказать звонок\"");

        step ("Заполняем поле \"Телефон\"");

        step ("Нажимаем кнопку \"Отправить\"");
    }

    @Test
    @Tag("web")
    //@AllureId("3154")
    @DisplayName("Поле \"Телефон\" обязательно к заполнению")
    void phoneMustBeCompletedTest() {
        step ("Открываем главную страницу", ()-> open(""));

        step ("Нажимаем на кнопку \"Заказать звонок\"");

        step ("Заполняем поле \"Ваше имя\"");

        step ("Нажимаем кнопку \"Отправить\"");
    }

    @Test
    @Tag("web")
    //@AllureId("3154")
    @DisplayName("Можно отправить заявку на обратный звонок")
    void userCanSendOrderToCallBackTest() {
        step ("Открываем главную страницу", ()-> open(""));

        step ("Нажимаем на кнопку \"Заказать звонок\"");

        step ("Заполняем поле \"Ваше имя\"");
        step ("Заполняем поле \"Телефон\"");

        step ("Нажимаем кнопку \"Отправить\"");

        step ("Форма закрывается");

        step ("ToDo Проверяем в БД, что данные пользователя сохранились");

    }

}


