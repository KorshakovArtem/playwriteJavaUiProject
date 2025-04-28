package test.tests;

import org.testng.annotations.Test;
import test.pages.progressBarPage;
import static org.testng.Assert.assertEquals;

public class progressBarTest extends BaseTest {
    final String urlPath = "progressbar";
    final int valueToStop = 75;


    @Test
    public void testProgressBar() {
        goToPath(urlPath);
        var progressBarPage = new progressBarPage(page);
        assertEquals(progressBarPage.progressBarTestWaitForValueAndClickOnStopButton(valueToStop).
                getValueOfProgressBar(), valueToStop);
    }
}
