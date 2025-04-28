package test.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class progressBarPage {

    final Page page;

    public progressBarPage(Page page){
        this.page = page;
    }

    private Locator startButton() {
        return this.page.locator("[id=startButton]");
    }
    private Locator stopButton() {
        return this.page.locator("[id=stopButton]");
    }
    private Locator progressBar() {
        return this.page.locator("[id=progressBar]");
    }



    public progressBarPage clickOnStartButton() {
        startButton().scrollIntoViewIfNeeded();
        startButton().isVisible();
        startButton().hover();
        startButton().click();
        return new progressBarPage(page);
    }

    public progressBarPage clickOnStopButton() {
        stopButton().scrollIntoViewIfNeeded();
        stopButton().isVisible();
        stopButton().hover();
        stopButton().click();
        return new progressBarPage(page);
    }

    public int getValueOfProgressBar() {
        return Integer.parseInt(progressBar().getAttribute("aria-valuenow"));
    }

    public progressBarPage progressBarTestWaitForValueAndClickOnStopButton(int value) {
        clickOnStartButton();
        page.waitForFunction(
                "element => parseInt(element.getAttribute('aria-valuenow')) === " + value,
                progressBar().evaluateHandle("el => el") // Прямой доступ к элементу по ID
        );
        clickOnStopButton();
        return new progressBarPage(page);
    }
}
