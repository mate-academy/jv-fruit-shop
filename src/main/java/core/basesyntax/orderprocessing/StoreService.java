package core.basesyntax.orderprocessing;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import core.basesyntax.operations.Operable;
import core.basesyntax.operations.PerformStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {
    private List<FruitPack> performedPacks = new ArrayList<>();

    public void performOperations(List<Order> orders) {
        for (Order order : orders) {
            Operable operation = PerformStrategy.getStrategy(order.getTypeOfOperation());
            performedPacks = operation.perform(order, performedPacks);
        }
    }

    public Map<String, Integer> formatResult() {
        Map<String, Integer> totalResult = new HashMap<>();
        for (FruitPack fp : performedPacks) {
            String key = fp.getName();
            if (totalResult.containsKey(key)) {
                totalResult.put(key, totalResult.get(key) + fp.getQuantity());
            } else {
                totalResult.put(key, fp.getQuantity());
            }
        }
        return totalResult;
    }
}
