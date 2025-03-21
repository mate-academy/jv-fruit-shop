package core.basesyntax.operationstrategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationservice.BalanceOperationImpl;
import core.basesyntax.operationservice.OperationHandler;
import core.basesyntax.operationservice.PurchaseOperationImpl;
import core.basesyntax.operationservice.ReturnOperationImpl;
import core.basesyntax.operationservice.SupplyOperationImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler>
            operationOperationHandlerHashMap = new HashMap<>();

    public OperationStrategyImpl() {
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .BALANCE, new BalanceOperationImpl());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .SUPPLY, new SupplyOperationImpl());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .PURCHASE, new PurchaseOperationImpl());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .RETURN, new ReturnOperationImpl());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationOperationHandlerHashMap.get(operation);
    }
}
