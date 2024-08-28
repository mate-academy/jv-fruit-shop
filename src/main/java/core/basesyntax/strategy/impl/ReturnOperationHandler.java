package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.QuantityIncrementer;
import java.util.Map;

public class ReturnOperationHandler implements OperationHandler {
    private final QuantityIncrementer incrementer;

    public ReturnOperationHandler(QuantityIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @Override
    public void process(Map<String, Integer> fruitQuantityMap,
                        FruitTransaction transaction) {
        incrementer.incrementByQuantity(fruitQuantityMap, transaction);
    }
}
