package core.basesyntax.operations;

import core.basesyntax.orderprocessing.OrdersReader;
import core.basesyntax.orderprocessing.OrdersStorage;
import core.basesyntax.orderprocessing.StoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

public class SupplyingTest {
    private final String BUY_PATH =
            "src/test/resources/supply.csv";
    private OrdersReader ordersReader;
    private OrdersStorage ordersStorage;
    private StoreService storeService;

    @Before
    public void setUp() {
        ordersReader = new OrdersReader();
        ordersStorage = new OrdersStorage();
        storeService = new StoreService();
    }

    @Test
    public void performBuyOrder() {
        ordersStorage.addOrders(ordersReader.formOrders(BUY_PATH));
        storeService.performOperations(ordersStorage.getOrders());
        Map<String, Integer> map = storeService.formatResult();
        int excepted = 33;
        Assert.assertTrue(map.containsValue(excepted));
    }
}
