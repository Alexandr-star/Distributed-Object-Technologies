import PageObject.YandexResultPageObject;
import PageObject.YandexSearchPageObject;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Search_uniyar_in_Yandex_Test {

    @Test
    public void Search_Uniar_in_Yandex() {
        open("https://yandex.ru/");
        new YandexSearchPageObject().searchFor("ЯрГУ ИВТ");

        YandexResultPageObject results = new YandexResultPageObject();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResult(0).shouldHave(text("ivt.uniyar.ac.ru"));
    }
}
