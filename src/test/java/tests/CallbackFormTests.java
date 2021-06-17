package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CallbackFormTests extends TestBase{

    @Test
    @Tag("web")
    void openCallbackFormTest()
    {

        open("");
        //order_call

        sleep(5000);
    }
}
