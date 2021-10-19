package core.basesyntax.service.operation;

import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> fruitQuantityMap, String fruitName, int quantity) {
        fruitQuantityMap.put(fruitName, quantity);
    }
}
