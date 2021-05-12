package PageObject;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddItemPageObject {
    public void AddItem(String text) {
        $(By.className("form-control")).val(text).pressEnter();
    }
}
