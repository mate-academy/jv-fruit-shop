package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class ReturnTest {
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String KEY = "banana";
    private static Operation aReturn;

    @BeforeClass
    public static void prepareEnvironmentBeforeTest(){
        Storage.storage.clear();
        aReturn = new Return();
    }

    @Before
    public void fillTheStorage() {
        Storage.storage.put("banana",
                new Storage.DateAndQuantityPair(
                        LocalDate.of(2020, 10, 11), 50));
    }

    @After
    public void clearTheStorage() {
        Storage.storage.clear();
    }

    @Test
    public void testNormalReturn() {
        aReturn.provideOperation(
                new Transaction("r", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.storage.get(KEY).getAllQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void testReturnNonExistingFruit() {
        aReturn.provideOperation(
                new Transaction("r","potato","200","2020-10-07"));
    }
}
