package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DynamicIdTestPage {

    private final Page page;

    public DynamicIdTestPage(Page page) {
        this.page = page;
    }

    private Locator dynamicBtn() {
        return this.page.locator("//button[contains(text(), 'Button with Dynamic ID')]");
    }

    public DynamicIdTestPage clickOnDynamicIdButton() {
        dynamicBtn().scrollIntoViewIfNeeded();
        dynamicBtn().isVisible();
        dynamicBtn().hover();
        dynamicBtn().click();
        return new DynamicIdTestPage(page);
    }

    public boolean isdynamicIdButtonVisible() {
        return dynamicBtn().isVisible();
    }



}
