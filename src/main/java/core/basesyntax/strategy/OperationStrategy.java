package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class OperationStrategy {

    public OperationStrategy(
            Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        operationHandlerMap.put(
                FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(
                FruitTransaction.Operation.RETURN, new ReturnHandler());
    }
}
