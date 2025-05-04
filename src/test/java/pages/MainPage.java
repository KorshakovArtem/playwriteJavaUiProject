package pages;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Locator;
import tests.BaseTest;

public class MainPage extends BaseTest {
    private final Page page;
    final String websiteLink = "http://uitestingplayground.com/";

    private Locator mainPageDescription() {
        return this.page.locator("//section[@id='description']");
    }

    private Locator dynamicIdTestButton() {
        return this.page.locator("[href='/dynamicid']");
    }

    private Locator clickTestButton() {
        return this.page.locator("[href='/click']");
    }

    private Locator textInputTestButton() {
        return this.page.locator("[href='/textinput']");
    }

    public MainPage(Page page) {
        this.page = page;
    }

    public  void isMainPageDescriptionPresented(){
        assertThat(mainPageDescription()).isVisible();
    }

    public void isMainPageOpened(String pageUrl){
        page.navigate(websiteLink);
        assertEquals(page.url(), websiteLink);
        final String pageTitle = page.url();
        assertEquals(pageTitle, pageUrl);
    }

    public  DynamicIdTestPage clickOnDynamicIdTestButton() {
        dynamicIdTestButton().scrollIntoViewIfNeeded();
        dynamicIdTestButton().isVisible();
        dynamicIdTestButton().hover();
        dynamicIdTestButton().click();
        return new DynamicIdTestPage(page);
    }

    public  ClickTestPage clickOnClickTestButton() {
        clickTestButton().scrollIntoViewIfNeeded();
        clickTestButton().isVisible();
        clickTestButton().hover();
        clickTestButton().click();
        return new ClickTestPage(page);
    }

    public InputTextTestPage clickOnInputTextTestButton() {
        textInputTestButton().scrollIntoViewIfNeeded();
        textInputTestButton().isVisible();
        textInputTestButton().hover();
        textInputTestButton().click();
        return new InputTextTestPage(page);
    }
}
