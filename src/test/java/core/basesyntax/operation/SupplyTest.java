package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class SupplyTest {
    private static final Integer EXPECTED_QUANTITY = 60;
    private static final String KEY = "banana";
    private static Operation supply;

    @BeforeClass
    public static void prepareEnvironmentForTests() {
        supply = new Supply();
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
    public void testSupplyWithExistingFruit() {
        supply.provideOperation(
                new Transaction("s", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.storage.get(KEY).getAllQuantity());
    }

    @Test
    public void testSupplyWithNewFruit() {
        supply.provideOperation(
                new Transaction("s", "orange", "30", "2020-10-07"));
        Assert.assertTrue(Storage.storage.size() > 1);
    }
}
