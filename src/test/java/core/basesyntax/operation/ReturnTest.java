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
    public static void beforeClass() throws Exception {
        aReturn = new Return();
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
    public void returnNormalTest() {
        aReturn.provideOperation(new Transaction("r", "banana", "10", "2020-10-07"));
        Assert.assertEquals(EXPECTED_QUANTITY, Storage.storage.get(KEY).getQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void returnNonExistingFruit() {
        aReturn.provideOperation(new Transaction("r","potato","200","2020-10-07"));
    }
}
