package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.QuantityIncrementer;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    private final QuantityIncrementer incrementer;

    public SupplyOperationHandler(QuantityIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @Override
    public void process(Map<String, Integer> fruitQuantityMap,
                        FruitTransaction transaction) {
        incrementer.incrementByQuantity(fruitQuantityMap, transaction);
    }
}
