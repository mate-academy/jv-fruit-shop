package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.QuantityIncrementer;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class SupplyOperationHandler extends AbstractOperationHandler {
    private final QuantityIncrementer incrementer;

    public SupplyOperationHandler(MapValidator mapValidator, QuantityIncrementer incrementer) {
        super(Operation.SUPPLY, mapValidator);
        this.incrementer = incrementer;
    }

    @Override
    public void processTransaction(Map<String, Integer> fruitQuantityMap,
                                   FruitTransaction transaction) {
        incrementer.incrementByQuantity(fruitQuantityMap, transaction);
    }
}
