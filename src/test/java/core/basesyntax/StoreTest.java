package core.basesyntax;

import core.basesyntax.impl.OrderExecutorService;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class StoreTest {
    private static final LocalDate NOW_DATE = LocalDate.now();
    private static final String FILE_BIG_AMOUNT
            = "src/test/testBigAmount.csv";
    private static final String FILE_EXP_DATE
            = "src/test/testExpDate.csv";
    private static final String FILE_EQUALS
            = "src/test/equalsTest.csv";
    private static final String FILE_EMPTY
            = "src/test/testEmpty.csv";
    private static OrderExecutorService oes;

    @Before
    public void create() {
        Storage.fruitStorage.clear();
        oes = new OrderExecutorService();
    }

    @Test
    public void bigAmountTest() {
//        Storage.fruitStorage.clear();
        String actual = oes.execute(FILE_BIG_AMOUNT);
        assertEquals("banana,280", actual);
    }

    @Test (expected = NullPointerException.class)
    public void emptyFileTest() {
        oes.execute(FILE_EMPTY);
    }

    @Test
    public void expiryDateTest() {
        String actual = oes.execute(FILE_EXP_DATE);
        assertEquals("banana,80", actual);
    }

    @Test
    public void equalsTest() {

    }
}
