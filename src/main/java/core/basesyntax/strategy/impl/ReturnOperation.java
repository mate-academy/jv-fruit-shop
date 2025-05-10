package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Map<String, Integer> fruits = Storage.getFruits();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        fruits.merge(fruit, quantity, Integer::sum);
    }
}
