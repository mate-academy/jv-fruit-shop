package core.basesyntax.strategy.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.ChooseStrategyHandler;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class ChooseStrategyHandlerImpl implements ChooseStrategyHandler {
    private final Map<FruitTransaction.Operation, OperationHandler> mapOfOperations;

    public ChooseStrategyHandlerImpl() {
        mapOfOperations = new HashMap<>();
        insertOperations();
    }

    @Override
    public OperationHandler get(FruitTransaction fruitTransaction) {
        return mapOfOperations.get(fruitTransaction.getOperation());
    }

    private void insertOperations() {
        mapOfOperations.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());
        mapOfOperations.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());
    }
}
