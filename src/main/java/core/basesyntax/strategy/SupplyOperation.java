package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), storage
                .getOrDefault(transaction.getFruit(), 0) + transaction.getQuantity());
    }
}
