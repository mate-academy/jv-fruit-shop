package core.basesyntax.service;

import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void process(FruitTransaction tx, Map<String, Integer> storage) {
        storage.put(tx.getFruit(), tx.getQuantity());
    }
}
