package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.mapvalidator.KeyAbsentValidator;
import java.util.Map;

public class BalanceOperationHandler
        extends AbstractOperationHandler
        implements KeyAbsentValidator {
    public BalanceOperationHandler() {
        super(Operation.BALANCE);
    }

    @Override
    protected void processTransaction(Map<String, Integer> fruitQuantityMap,
                                      FruitTransaction transaction) {
        validateMap(fruitQuantityMap, transaction);
        fruitQuantityMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}
