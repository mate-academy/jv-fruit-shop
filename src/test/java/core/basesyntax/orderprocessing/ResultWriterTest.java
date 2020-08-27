package core.basesyntax.orderprocessing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class ResultWriterTest {
    private static final String BIG_TEST_PATH =
            "C:\\Users\\User\\IdeaProjects\\JUnit_Practise\\src\\test\\resources\\bigTest.csv";
    private static final String BIG_TEST_OUTPUT =
            "C:\\Users\\User\\IdeaProjects\\JUnit_Practise\\src\\test\\resources\\bigTestOUT.csv";
    private OrdersReader ordersReader;
    private OrdersStorage ordersStorage;
    private StoreService storeService;
    private ResultWriter resultWriter;


    @Before
    public void setUp() {
        ordersReader = new OrdersReader();
        ordersStorage = new OrdersStorage();
        storeService = new StoreService();
        resultWriter = new ResultWriter();
    }

    @Test
    public void writeResult() {
        ordersStorage.addOrders(ordersReader.formOrders(BIG_TEST_PATH));
        storeService.performOperations(ordersStorage.getOrders());
        resultWriter.writeResult(BIG_TEST_OUTPUT, storeService.formatResult());
        File file = new File(BIG_TEST_OUTPUT);
        Assert.assertTrue(file.exists());
    }
}
