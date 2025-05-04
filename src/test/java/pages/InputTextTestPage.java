package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static org.testng.Assert.assertEquals;

public class InputTextTestPage {
    private final Page page;


    public  InputTextTestPage (Page page){
        this.page = page;
    }

    private Locator textInputField() {
        return this.page.getByPlaceholder ("MyButton");
    }

    private Locator updatingBtn() {
        return this.page.locator("[id=updatingButton]");
    }

    public InputTextTestPage fillMyButtonPlaceHoldesWithText(String textValue){
        textInputField().scrollIntoViewIfNeeded();
        textInputField().isVisible();
        textInputField().fill(textValue);
        return new InputTextTestPage(page);
    }

    public InputTextTestPage clickOnUpdatingButton() {
        updatingBtn().scrollIntoViewIfNeeded();
        updatingBtn().isVisible();
        updatingBtn().hover();
        updatingBtn().click();
        return new InputTextTestPage(page);
    }

    public String getValueFromUpdatingButton() {
        return updatingBtn().innerText();
    }

}
