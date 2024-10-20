package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerFactory;
import core.basesyntax.strategy.OperationStrategy;

import java.util.HashMap;
import java.util.Map;

public class OperationHandlerFactoryImpl implements OperationHandlerFactory {

    public OperationStrategy createOperationStrategy() {
        Map<FruitTransaction.getOperation, OperationHandler> operationHandlers = new Map<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());

        return new OperationStrategyImpl(operationHandlers);
    }
}
