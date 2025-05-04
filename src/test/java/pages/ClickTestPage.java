package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ClickTestPage {
    private final Page page;


    public ClickTestPage(Page page) {
        this.page = page;
    }

    private Locator badClickBtn() {
        return this.page.locator("[id=badButton]");
    }

    public ClickTestPage clickOnBadClickButton() {
        badClickBtn().scrollIntoViewIfNeeded();
        badClickBtn().isVisible();
        badClickBtn().hover();
        badClickBtn().click();
        return new ClickTestPage(page);
    }

    public String checkIsBadClickButtonWasClicked() {
        return badClickBtn().getAttribute("class");
    }


}
