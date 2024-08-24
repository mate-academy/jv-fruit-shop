package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.QuantityIncrementer;
import java.util.Map;

public class SupplyOperationHandler
        extends AbstractOperationHandler
        implements QuantityIncrementer {
    public SupplyOperationHandler() {
        super(Operation.SUPPLY);
    }

    @Override
    public void processTransaction(Map<String, Integer> fruitQuantityMap,
                                   FruitTransaction transaction) {
        incrementByQuantity(fruitQuantityMap, transaction);
    }
}
