package Project;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TestngReport {
    @Test
    public void testAddition() {
        int a = 5;
        int b = 10;
        int result = a + b;
        Assert.assertEquals(result, 15, "Sum should be 15");
    }

    @Test
    public void testSubtraction() {
        int a = 10;
        int b = 5;
        int result = a - b;
        Assert.assertEquals(result, 5, "Difference should be 5");
    }


}
