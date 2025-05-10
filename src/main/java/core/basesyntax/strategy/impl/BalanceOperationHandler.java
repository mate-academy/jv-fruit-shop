package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(Map<String, Integer> fruitQuantityMap, FruitTransaction transaction) {
        fruitQuantityMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}
