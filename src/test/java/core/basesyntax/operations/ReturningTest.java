package core.basesyntax.operations;

import core.basesyntax.orderprocessing.CsvFileReader;
import core.basesyntax.orderprocessing.OrdersStorage;
import core.basesyntax.orderprocessing.StoreService;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class ReturningTest {
    private static final String BUY_PATH = "src/test/resources/return.csv";
    private final CsvFileReader csvFileReader = new CsvFileReader();
    private final OrdersStorage ordersStorage  = new OrdersStorage();
    private final StoreService storeService = new StoreService();

    @Test
    public void performBuyOrder() {
        ordersStorage.addOrders(csvFileReader.formOrders(BUY_PATH));
        storeService.performOperations(ordersStorage.getOrders());
        Map<String, Integer> map = storeService.formatResult();
        int excepted = 33;
        Assert.assertTrue(map.containsValue(excepted));
    }
}
