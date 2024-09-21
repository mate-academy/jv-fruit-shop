package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(Map<String, Integer> storage, FruitTransaction transaction) {
        storage.put(transaction.getFruit(),
                storage.getOrDefault(transaction.getFruit(), 0)
                        + transaction.getQuantity());
    }
}

