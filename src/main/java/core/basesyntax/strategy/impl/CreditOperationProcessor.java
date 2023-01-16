package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;
import java.util.Optional;

public class CreditOperationProcessor implements OperationHandler {

    @Override
    public int get(FruitTransaction fruitRecord, Map<String, Integer> fruits) {
        Optional<Integer> optional = Optional.ofNullable(fruits.get(fruitRecord.getFruit()));
        return optional.orElse(0) + fruitRecord.getQuantity();
    }
}
