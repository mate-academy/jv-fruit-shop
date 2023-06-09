package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.OperationBalanceHandler;
import core.basesyntax.service.operation.impl.OperationPurchaseHandler;
import core.basesyntax.service.operation.impl.OperationReturnHandler;
import core.basesyntax.service.operation.impl.OperationSupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {

    public FruitShopServiceImpl() {
    }

    @Override
    public void processOfOperations(List<FruitTransaction> fruitTransactions) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new OperationBalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new OperationReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new OperationSupplyHandler());
        for (FruitTransaction current : fruitTransactions) {
            operationHandlerMap.get(current.getOperation())
                    .operationHandler(current);
        }
    }
}

