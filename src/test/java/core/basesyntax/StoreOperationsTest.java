package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class StoreOperationsTest {

    @Test(expected = IllegalArgumentException.class)
    public void operationCharacterNegativeTest() {
        StoreOperations.calculate(13, 5, "o");
        StoreOperations.calculate(13, 5, "+");
    }

    @Test
    public void ProperOperationsOk() {
        Assert.assertEquals(75, StoreOperations.calculate(57, 18, "s"));
        Assert.assertEquals(88, StoreOperations.calculate(111, 23, "b"));
        Assert.assertEquals(258, StoreOperations.calculate(240, 18, "r"));
    }
}
