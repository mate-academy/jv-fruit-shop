package core.basesyntax.service.operations.strategy;

import java.util.Map;

public class BalanceOperationHandler implements IOperationHandler {

    @Override
    public void performOperation(String name, int quantity, Map<String, Integer> fruitQuantityMap) {
        fruitQuantityMap.put(name, quantity);
    }
}
