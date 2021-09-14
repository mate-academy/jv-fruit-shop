package core.basesyntax.services.handlers;

import core.basesyntax.model.Operation;
import java.util.Map;

public class BalanceFruitHandler implements FruitHandler {
    @Override
    public int newQuantity(Operation operation, Map<String, Integer> fruitStorage) {
        fruitStorage.put(operation.getFruit(),0);
        return operation.getQuantity();
    }
}
