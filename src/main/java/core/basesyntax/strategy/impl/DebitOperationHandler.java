package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationCalculator;
import java.util.Map;
import java.util.Optional;

public class DebitOperationHandler implements OperationCalculator {
    @Override
    public int calculate(FruitTransaction fruitTransaction, Map<String, Integer> fruitsMap) {
        String fruit = fruitTransaction.getFruit();
        Optional<Integer> quantityOptional =
                Optional.ofNullable(fruitsMap.get(fruit));
        int amount = quantityOptional.orElseThrow(() ->
                new RuntimeException("No such fruit was found."))
                - fruitTransaction.getQuantity();
        if (amount < 0) {
            throw new RuntimeException("Not enough " + fruit + " for sale.");
        }
        return amount;
    }
}
