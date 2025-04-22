package test.tests;

import org.testng.annotations.Test;
import test.pages.MainPage;
import static org.testng.Assert.assertEquals;

public class InputTextTest extends BaseTest{
    final String testValue = "testValue";

    @Test
    public void inputTextTest(){
        assertEquals(
                openPage().
                        clickOnInputTextTestButton().
                        fillMyButtonPlaceHoldesWithText(testValue).
                        clickOnUpdatingButton().
                        getValueFromUpdatingButton(),testValue);
    }
}
