package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import core.basesyntax.strategy.service.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final StorageService storageService;
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public TransactionProcessorImpl(StorageService storageService) {
        this.storageService = storageService;
        this.operationHandlerMap = initializeOperationHandlerMap(storageService);
    }

    @Override
    public void executeTransactions(List<FruitsTransaction> transactions) {
        for (FruitsTransaction transaction : transactions) {
            Operation operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            if (handler == null) {
                throw new InvalidOperationException("Cannot perform operation: " + operation);
            }
            handler.perform(transaction);
        }
    }

    private Map<Operation, OperationHandler> initializeOperationHandlerMap(
            StorageService storageService) {
        Map<Operation, OperationHandler> map = new HashMap<>();
        map.put(Operation.BALANCE, new BalanceOperation(storageService));
        map.put(Operation.SUPPLY, new SupplyOperation(storageService));
        map.put(Operation.PURCHASE, new PurchaseOperation(storageService));
        map.put(Operation.RETURN, new ReturnOperation(storageService));
        return map;
    }
}
