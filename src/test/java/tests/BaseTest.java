package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;
import pages.MainPage;


public class BaseTest {
    public Playwright playwright;
    public Page page;
    public String pageUrl = "http://uitestingplayground.com/";


    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.playwright = Playwright.create();
        final Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        this.page = browser.newPage();
    }

    public MainPage openPage() {
        page.navigate(pageUrl);
        MainPage mainPage = new MainPage(page);
        mainPage.isMainPageOpened(this.pageUrl);
        mainPage.isMainPageDescriptionPresented();
        return new MainPage(page);
    }

    public void goToPath (String urlPath){
        page.navigate(pageUrl + urlPath);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        this.page.close();
    }
}
