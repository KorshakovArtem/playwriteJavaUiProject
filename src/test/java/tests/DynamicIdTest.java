package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class DynamicIdTest extends BaseTest{

    @Test
    public void testDynamicId() {
        assertTrue(
                openPage().
                        clickOnDynamicIdTestButton().
                        clickOnDynamicIdButton().
                        isdynamicIdButtonVisible()
        );
    }
}
