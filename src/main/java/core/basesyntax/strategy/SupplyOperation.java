package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction tx) {
        storage.merge(tx.getFruit(), tx.getQuantity(), Integer::sum);
    }
}

