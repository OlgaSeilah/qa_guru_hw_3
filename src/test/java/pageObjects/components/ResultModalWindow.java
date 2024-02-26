package pageObjects.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultModalWindow {
    private final SelenideElement modalWindow = $(".modal-dialog");
    private final ElementsCollection rows = $$("tbody td");

    public ResultModalWindow checkModalWindowIsVisible() {
        modalWindow.shouldBe(visible);

        return this;
    }

    public ResultModalWindow checkRowHasResult(String rowName, String result) {
        rows.findBy(text(rowName)).sibling(0).shouldHave(text(result));

        return this;
    }
}