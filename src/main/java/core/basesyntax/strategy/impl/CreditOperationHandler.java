package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationCalculator;
import java.util.Map;
import java.util.Optional;

public class CreditOperationHandler implements OperationCalculator {
    @Override
    public int calculate(FruitTransaction fruitTransaction, Map<String, Integer> fruitsMap) {
        Integer currentQuantity = Optional.ofNullable(fruitsMap.get(fruitTransaction.getFruit()))
                .orElse(0);
        return currentQuantity + fruitTransaction.getQuantity();
    }
}
