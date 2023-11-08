package core.basesyntax.dao;

import core.basesyntax.dao.operation.Operation;
import core.basesyntax.dao.operation.OperationHandler;
import core.basesyntax.dao.operation.ReturnOperation;
import core.basesyntax.dao.transaction.FruitTransaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageUpdatorImpl implements StorageUpdator {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public StorageUpdatorImpl() {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.RETURN, ReturnOperation)
    }

    @Override
    public void updateStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationHandlerMap.get(fruitTransaction.getOperation());
        }
    }
}
