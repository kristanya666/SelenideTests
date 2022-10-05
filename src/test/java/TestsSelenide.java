import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide. *;

public class TestsSelenide {

    @Test
    void shouldOpenURL() {
        open("http://localhost:9999");

        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Константин");
        form.$("[data-test-id=phone] input").setValue("+79969590415");
        form.$("[data-test-id=agreement]").click();
        form.$("form button[type=button]").click();
        $("div p[data-test-id=order-success]").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
