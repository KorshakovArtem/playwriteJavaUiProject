package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ClickTest extends BaseTest{
    private final String successedClickClassMeaning = "btn btn-success";

    @Test
    public void testClick() {
        assertEquals(
                openPage().
                clickOnClickTestButton().
                clickOnBadClickButton().
                checkIsBadClickButtonWasClicked(), successedClickClassMeaning);


    }
}
