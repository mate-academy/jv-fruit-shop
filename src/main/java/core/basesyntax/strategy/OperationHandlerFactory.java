package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerFactory {
    private final Map<Transaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
    private final StorageService storageService = new StorageServiceImpl();

    public OperationHandlerFactory() {
        operationHandlers.put(Transaction.Operation.S, new IncrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.R, new IncrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.P, new DecrementHandler(storageService));
        operationHandlers.put(Transaction.Operation.B, new IncrementHandler(storageService));
    }

    public OperationHandler getHandler(Transaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
