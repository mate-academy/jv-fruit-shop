package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoRequiredQuantityOfFruits;
import core.basesyntax.orderprocessing.CsvFileReader;
import core.basesyntax.orderprocessing.OrdersStorage;
import core.basesyntax.orderprocessing.StoreService;
import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class BuyingTest {
    private static final String BUY_PATH = "src/test/resources/buy.csv";
    private static final String BUY_MORE_PATH = "src/test/resources/buyMoreThanHave.csv";
    private final CsvFileReader csvFileReader = new CsvFileReader();;
    private final OrdersStorage ordersStorage = new OrdersStorage();
    private final StoreService storeService = new StoreService();

    @Test
    public void performBuyOrderOk() {
        ordersStorage.addOrders(csvFileReader.formOrders(BUY_PATH));
        storeService.performOperations(ordersStorage.getOrders());
        Map<String, Integer> map = storeService.formatResult();
        int excepted = 7;
        Assert.assertTrue(map.containsValue(excepted));
    }

    @Test(expected = NoRequiredQuantityOfFruits.class)
    public void performBuyMoreThanHave() {
        ordersStorage.addOrders(csvFileReader.formOrders(BUY_MORE_PATH));
        storeService.performOperations(ordersStorage.getOrders());
    }
}
