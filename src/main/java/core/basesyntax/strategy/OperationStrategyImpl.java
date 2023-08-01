package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;
import core.basesyntax.service.OperationStrategyService;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategyService {
    private final Map<FruitTransaction.Operation,
            OperationHandlerService> operationHandleMap = new HashMap<>();

    public OperationStrategyImpl() {
        operationHandleMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandleMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandleMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandleMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
    }

    @Override
    public OperationHandlerService getHandler(FruitTransaction.Operation operation) {
        return operationHandleMap.get(operation);
    }
}
