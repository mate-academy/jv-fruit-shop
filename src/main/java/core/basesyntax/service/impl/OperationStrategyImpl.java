package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.PurchareOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationHandler> dataOperation = new HashMap<>();

    @Override
    public OperationHandler get(Operation operation) {
        addOperation(dataOperation);
        return dataOperation.get(operation);
    }

    private void addOperation(Map<Operation, OperationHandler> dataOperation) {
        dataOperation.put(Operation.BALANCE, new BalanceOperationHandler());
        dataOperation.put(Operation.SUPPLY, new SupplyOperationHandler());
        dataOperation.put(Operation.PURCHASE, new PurchareOperationHandler());
        dataOperation.put(Operation.RETURN, new ReturnOperationHandler());
    }
}
