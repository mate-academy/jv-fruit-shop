package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void process(FruitTransaction tx, Map<String, Integer> storage) {
        storage.put(tx.getFruit(), tx.getQuantity());
    }
}
