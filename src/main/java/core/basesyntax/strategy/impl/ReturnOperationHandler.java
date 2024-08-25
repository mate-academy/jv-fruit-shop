package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.QuantityIncrementer;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class ReturnOperationHandler extends AbstractOperationHandler {
    private final QuantityIncrementer incrementer;

    public ReturnOperationHandler(MapValidator mapValidator, QuantityIncrementer incrementer) {
        super(Operation.RETURN, mapValidator);
        this.incrementer = incrementer;
    }

    @Override
    protected void processTransaction(Map<String, Integer> fruitQuantityMap,
                                      FruitTransaction transaction) {
        incrementer.incrementByQuantity(fruitQuantityMap, transaction);
    }
}
