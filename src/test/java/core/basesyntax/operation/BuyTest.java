package core.basesyntax.operation;

import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class BuyTest {
    private static final Integer EXPECTED_QUANTITY = 40;
    private static final String KEY = "banana";
    private static Operation buy;

    @BeforeClass
    public static void beforeClass() throws Exception {
        buy = new Buy();
    }

    @Before
    public void setUp() {
        Storage.storage.put("banana",
                new Storage.DateAndQuantityPair(
                        LocalDate.of(2020, 10, 11), 50));
    }

    @After
    public void tearDown() {
        Storage.storage.clear();
    }

    @Test
    public void buyTest() {
        buy.provideOperation(new Transaction("b", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.storage.get(KEY).getQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void buyDateExpiredTest() {
        buy.provideOperation(new Transaction("b", "banana", "10", "2020-10-12"));
    }

    @Test(expected = RuntimeException.class)
    public void buyOutOfFruitTest() {
        buy.provideOperation(new Transaction("b", "banana", "60", "2020-10-05"));
    }
}
