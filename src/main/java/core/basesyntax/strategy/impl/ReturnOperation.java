package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        String owoc = transaction.getFruit();
        int ilosc = transaction.getQuantity();
        int stan = storage.getOrDefault(owoc, 0);
        storage.put(owoc, stan + ilosc);
    }
}
