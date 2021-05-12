package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultAddedItem {
    public ElementsCollection getResults() {
        return $$(By.className("name"));
    }

    public SelenideElement getResultByIndex(int index) {
        return $(By.className("name"), index);
    }

    public ElementsCollection getItems() {
        return $$(By.className("item"));
    }

    public SelenideElement getDeleteButton() {
        return $(By.className())
    }
}
