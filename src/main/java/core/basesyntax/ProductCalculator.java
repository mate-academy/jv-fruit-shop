package core.basesyntax;

import core.basesyntax.shopservice.AddToShopOperation;
import core.basesyntax.shopservice.ShopOperation;
import core.basesyntax.shopservice.SubstractShopOperation;
import dto.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCalculator {

    private Storage storage;
    private Map<String, ShopOperation> commandMap = new HashMap<>();

    public ProductCalculator(Storage storage) {
        this.storage = storage;
        commandMap();
    }

    private void commandMap() {
        commandMap.put("b", new SubstractShopOperation(storage));
        commandMap.put("r", new AddToShopOperation(storage));
        commandMap.put("s", new AddToShopOperation(storage));
    }

    public void ordersToStorage(List<Order> orderList) {
        for (Order order : orderList) {
            ShopOperation operation = commandMap.get(order.getType());
            operation.operate(order);
        }
    }
}
