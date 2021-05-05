package core.basesyntax.strategy;

import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.AlreadyHaveItException;
import core.basesyntax.service.StorageService;
import java.util.HashMap;
import java.util.List;

public class OperationService {
    private final HashMap<Operation.OperationType, OperationHandler> operationMap = new HashMap<>();

    public OperationService(StorageService storage) {
        operationMap.put(Operation.OperationType.BALANCE, new BalanceOperationHandlerImpl(storage));
        operationMap.put(Operation.OperationType.SUPPLY, new AddingOperationHandlerImpl(storage));
        operationMap.put(Operation.OperationType.PURCHASE,
                new SubtractingOperationHandlerImpl(storage));
        operationMap.put(Operation.OperationType.RETURN, new AddingOperationHandlerImpl(storage));
    }

    public void applyOperations(List<Operation> list) {
        for (Operation operation : list) {
            operationMap.get(operation.getOperationType()).handle(operation);
        }
    }
}
