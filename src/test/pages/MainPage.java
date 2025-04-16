package test.pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Locator;
import test.tests.BaseTest;

public class MainPage extends BaseTest {
    private final Page page;
    final String websiteLink = "http://uitestingplayground.com/";
    private Browser context;

    private Locator mainPageDescription() {
        return this.page.locator("//section[@id='description']");
    }

    private Locator dynamicIdTestButton() {
        return this.page.locator("[href='/dynamicid']");
    }

    private Locator dynamicBtn() {
        return this.page.locator("[xpath='1']");
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
        dynamicIdTestButton().isVisible();
        dynamicIdTestButton().hover();
        dynamicIdTestButton().click();
        return new DynamicIdTestPage(page);
    }
}
