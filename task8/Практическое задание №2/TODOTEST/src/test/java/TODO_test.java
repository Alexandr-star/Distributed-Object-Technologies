import PageObject.AddItemPageObject;
import PageObject.DeleteItemPageObject;
import PageObject.SearchResultAddedItem;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class TODO_test {

    @Test
    public void Add_Item_Test() {
        open("http://localhost:3000/");
        new AddItemPageObject().AddItem("Item");

        SearchResultAddedItem results = new SearchResultAddedItem();
        results.getResults().shouldHave(sizeGreaterThan(1));
        results.getResultByIndex(0).shouldHave(text("Item"));
    }

    @Test
    public void Delete_Item_Test() {
        open("http://localhost:3000/");

        new DeleteItemPageObject().DeleteItemByName("Item");

    }

}
