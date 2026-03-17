package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Objects;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> storage) {
        Objects.requireNonNull(transaction);
        Objects.requireNonNull(storage);
        // BALANCE sets the initial amount (replace)
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
