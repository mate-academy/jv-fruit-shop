package core.basesyntax.orderprocessing;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class CsvFileWriterTest {
    private static final String BIG_TEST_PATH = "src/test/resources/bigTest.csv";
    private static final String BIG_TEST_OUTPUT = "src/test/resources/bigTestOUT.csv";
    private final CsvFileReader csvFileReader = new CsvFileReader();
    private final OrdersStorage ordersStorage = new OrdersStorage();
    private final StoreService storeService = new StoreService();
    private final CsvFileWriter csvFileWriter = new CsvFileWriter();

    @Test
    public void writeResult() {
        ordersStorage.addOrders(csvFileReader.formOrders(BIG_TEST_PATH));
        storeService.performOperations(ordersStorage.getOrders());
        csvFileWriter.writeResult(BIG_TEST_OUTPUT, storeService.formatResult());
        File file = new File(BIG_TEST_OUTPUT);
        Assert.assertTrue(file.exists());
    }
}
