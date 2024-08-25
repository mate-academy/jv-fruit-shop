package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.strategy.validator.MapValidator;
import java.util.Map;

public class BalanceOperationHandler extends AbstractOperationHandler {
    public BalanceOperationHandler(MapValidator mapValidator) {
        super(Operation.BALANCE, mapValidator);
    }

    @Override
    protected void processTransaction(Map<String, Integer> fruitQuantityMap,
                                      FruitTransaction transaction) {
        fruitQuantityMap.put(transaction.getFruit(), transaction.getQuantity());
    }
}
