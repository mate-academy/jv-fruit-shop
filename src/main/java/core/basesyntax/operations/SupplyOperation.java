package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class SupplyOperation implements Supply {
    private final Map<String, Integer> stockBalance = Storage.getStockBalance();

    @Override
    public void supplyFruit(String fruit, int quantity) {
        if (stockBalance.containsKey(fruit)) {
            int fruitsAmount = stockBalance.get(fruit);
            stockBalance.merge(fruit, fruitsAmount, (a, b) -> b + quantity);
        } else {
            stockBalance.put(fruit, quantity);
        }
    }
}
