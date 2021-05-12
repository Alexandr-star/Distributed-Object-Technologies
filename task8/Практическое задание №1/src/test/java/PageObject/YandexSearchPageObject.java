package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class YandexSearchPageObject {
    public void searchFor(String text) {
        $(By.className("input__control")).val(text).pressEnter();
    }
}
