package core.basesyntax.model;

import core.basesyntax.exception.InvalidOperationException;
import core.basesyntax.model.entities.Product;
import core.basesyntax.model.impl.BalanceOperation;
import core.basesyntax.model.impl.PurchaseOperation;
import core.basesyntax.model.impl.ReturnOperation;
import core.basesyntax.model.impl.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationFactory<T extends Product> {
    private final Map<T, Integer> storage;
    private final Map<Operation, AbstractOperation<T>> operationMap;

    public OperationFactory(Map<T, Integer> storage) {
        this.storage = storage;
        operationMap = new HashMap<>();
        initOperationMap();
    }

    private void initOperationMap() {
        operationMap.put(Operation.B, new BalanceOperation<>(storage));
        operationMap.put(Operation.S, new SupplyOperation<>(storage));
        operationMap.put(Operation.P, new PurchaseOperation<>(storage));
        operationMap.put(Operation.R, new ReturnOperation<>(storage));
    }

    public AbstractOperation<T> get(Operation type) {
        AbstractOperation<T> operation = operationMap.get(type);
        if (operation == null) {
            throw new InvalidOperationException("Unknown operation found");
        }
        return operation;
    }
}
