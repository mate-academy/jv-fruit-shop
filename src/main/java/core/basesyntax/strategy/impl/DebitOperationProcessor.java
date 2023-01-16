package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class DebitOperationProcessor implements OperationHandler {

    @Override
    public int get(FruitTransaction fruitRecord, Map<String, Integer> fruits) {
        Optional<Integer> optional = Optional.ofNullable(fruits.get(fruitRecord.getFruit()));
        int amount = optional.orElseThrow(() -> new RuntimeException("No such fruit was found."))
                - fruitRecord.getQuantity();
        if (amount < 0) {
            throw new RuntimeException("Not enough fruit for sale.");
        }
        return amount;
    }
}
