package core.basesyntax.service.operations.strategy;

import java.util.Map;

public class ReturnOperationHandler implements IOperationHandler {

    @Override
    public void performOperation(String name, int quantity, Map<String, Integer> fruitQuantityMap) {
        fruitQuantityMap.replace(name, fruitQuantityMap.get(name) + quantity);
    }
}
