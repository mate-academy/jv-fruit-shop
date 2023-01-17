package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class CreditOperationProcessor implements OperationHandler {

    @Override
    public int get(FruitTransaction fruitTransaction, Map<String, Integer> fruits) {
        Integer currentQuantity = Optional.ofNullable(fruits.get(fruitTransaction.getFruit()))
                .orElse(0);
        return currentQuantity + fruitTransaction.getQuantity();
    }
}
