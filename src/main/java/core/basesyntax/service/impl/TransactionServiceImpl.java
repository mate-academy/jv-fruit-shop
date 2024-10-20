package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    FruitService fruitService;

    public TransactionServiceImpl(FruitService fruitService, FruitStorage fruitStorage){
        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler(fruitStorage));
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitStorage));
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler(fruitStorage));
        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler(fruitStorage));
    }

    @Override
    public void processTransaction(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            fruitService.processTransaction(transaction);
        }
    }
}
