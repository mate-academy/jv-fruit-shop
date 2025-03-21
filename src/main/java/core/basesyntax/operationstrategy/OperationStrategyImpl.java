package core.basesyntax.operationstrategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationservice.BalanceOperation;
import core.basesyntax.operationservice.OperationHandler;
import core.basesyntax.operationservice.PurchaseOperation;
import core.basesyntax.operationservice.ReturnOperation;
import core.basesyntax.operationservice.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler>
            operationOperationHandlerHashMap = new HashMap<>();

    public OperationStrategyImpl() {
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .BALANCE, new BalanceOperation());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .SUPPLY, new SupplyOperation());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .PURCHASE, new PurchaseOperation());
        operationOperationHandlerHashMap.put(FruitTransaction.Operation
                .RETURN, new ReturnOperation());
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return operationOperationHandlerHashMap.get(operation);
    }
}
