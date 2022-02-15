package core.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationsTest {
    @Test
    public void testForCorrectInput() {
        Operations firstExpected = Operations.BALANCE;
        Operations secondExpected = Operations.PURCHASE;
        Operations thirdExpected = Operations.RETURN;
        Operations firstActual = Operations.operationFromString("b");
        Operations secondActual = Operations.operationFromString("p");
        Operations thirdActual = Operations.operationFromString("r");
        assertEquals(firstExpected, firstActual);
        assertEquals(secondExpected, secondActual);
        assertEquals(thirdExpected, thirdActual);
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectData() {
        Operations.operationFromString("1235");
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataSecond() {
        Operations.operationFromString("");
    }

    @Test(expected = RuntimeException.class)
    public void testForIncorrectDataThird() {
        Operations.operationFromString("$");
    }
}
