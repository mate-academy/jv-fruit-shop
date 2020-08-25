package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class StoreOperationsTest {
    private static final int DELTA = 1;

    @Test(expected = IllegalArgumentException.class)
    public void operationCharacterNegativeTest() {
        StoreOperations.calculate(13, 5, "o");
        StoreOperations.calculate(13, 5, "+");
    }

    @Test
    public void ProperOperationsOk() {
        Assert.assertEquals(75.0, StoreOperations.calculate(57, 18, "s"), DELTA);
        Assert.assertEquals(88.0, StoreOperations.calculate(111, 23, "b"), DELTA);
        Assert.assertEquals(258.0, StoreOperations.calculate(240, 18, "r"), DELTA);
    }
}
