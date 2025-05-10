package core.basesyntax.handler.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    private final Map<String, Integer> fruitStorage;

    public SupplyOperation(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        fruitStorage.put(transaction.getFruit(), 
                fruitStorage.getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
