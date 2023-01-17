package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class DebitOperationProcessor implements OperationHandler {

    @Override
    public int get(FruitTransaction fruitTransaction, Map<String, Integer> fruits) {
        String fruit = fruitTransaction.getFruit();
        Optional<Integer> quantityOptional =
                Optional.ofNullable(fruits.get(fruit));
        int amount = quantityOptional.orElseThrow(() ->
                new RuntimeException("No such fruit was found."))
                - fruitTransaction.getQuantity();
        if (amount < 0) {
            throw new RuntimeException("Not enough " + fruit + " for sale.");
        }
        return amount;
    }
}
