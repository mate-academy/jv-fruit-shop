package core.basesyntax.orderprocessing;

import core.basesyntax.customexceptions.BadFileFormatting;
import core.basesyntax.entries.Order;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class CsvFileReaderTest {
    private static final String DEFAULT_PATH = "src/test/resources/";
    private static final String BIG_TEST = "bigTest.csv";
    private static final String SMALL_TEST = "smallTest.csv";
    private static final String EMPTY_TEST = "emptyTest.csv";
    private static final String WITHOUT_HEADER = "withoutHeader.csv";
    private static final String INVALID_PATH = "justAJoke";
    private final CsvFileReader csvFileReader = new CsvFileReader();

    @Test
    public void readSmallTest() {
        List<Order> orders = csvFileReader.formOrders(DEFAULT_PATH + SMALL_TEST);
        Assert.assertFalse(orders.isEmpty());
    }

    @Test
    public void readBigTest() {
        List<Order> orders = csvFileReader.formOrders(DEFAULT_PATH + BIG_TEST);
        Assert.assertFalse(orders.isEmpty());
    }

    @Test(expected = BadFileFormatting.class)
    public void readEmptyTest() {
        csvFileReader.formOrders(DEFAULT_PATH + EMPTY_TEST);
    }

    @Test(expected = BadFileFormatting.class)
    public void readWithoutHeaderTest() {
        csvFileReader.formOrders(DEFAULT_PATH + WITHOUT_HEADER);
    }

    @Test(expected = RuntimeException.class)
    public void readInvalidTest() {
        csvFileReader.formOrders(DEFAULT_PATH + INVALID_PATH);
    }
}
