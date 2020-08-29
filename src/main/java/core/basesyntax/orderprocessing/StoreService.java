package core.basesyntax.orderprocessing;

import core.basesyntax.entries.FruitPack;
import core.basesyntax.entries.Order;
import core.basesyntax.operations.Operable;
import core.basesyntax.operations.StrategyPerformer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {
    private List<FruitPack> performedPacks = new ArrayList<>();
    private StrategyPerformer strategyPerformer = new StrategyPerformer();

    public void performOperations(List<Order> orders) {
        for (Order order : orders) {
            Operable operation = strategyPerformer.getStrategy(order.getTypeOfOperation());
            performedPacks = operation.perform(order, performedPacks);
        }
    }

    public Map<String, Integer> formatResult() {
        Map<String, Integer> totalResult = new HashMap<>();
        for (FruitPack fruitPack : performedPacks) {
            String key = fruitPack.getName();
            totalResult.merge(key, fruitPack.getQuantity(), Integer::sum);
        }
        return totalResult;
    }
}
