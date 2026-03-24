package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> storage, FruitTransaction tx) {
        storage.put(tx.getFruit(), tx.getQuantity());

    }
}

