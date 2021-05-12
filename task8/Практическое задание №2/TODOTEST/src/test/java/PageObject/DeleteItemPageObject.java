package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DeleteItemPageObject {
    public void DeleteItemByName(String text) {
        SearchResultAddedItem results = new SearchResultAddedItem();
        ElementsCollection items = results.getItems();

        for (int i = 0; i < items.size(); i++) {
            boolean isEquals = items.get(i).getText().equals(text);
            if (isEquals) {
                SelenideElement deletedButton = items.get(i).$(By.partialLinkText("Remove Item"));
            }
        }
    }

}
