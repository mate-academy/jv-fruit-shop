package core.basesyntax.strategy;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.TransactionHandle;
import core.basesyntax.operations.impl.BalanceTransactionHandleImpl;
import core.basesyntax.operations.impl.PurchaseTransactionHandleImpl;
import core.basesyntax.operations.impl.ReturnTransactionHandleImpl;
import core.basesyntax.operations.impl.SupplyTransactionHandleImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, TransactionHandle> operationHandler = new HashMap<>();
    private StorageDao storage;

    public OperationStrategyImpl(StorageDao storage) {
        this.storage = storage;
        fillMap();
    }

    @Override
    public TransactionHandle get(FruitTransaction.Operation operation) {
        if (!operationHandler.containsKey(operation)) {
            throw new RuntimeException("Wrong operation ->" + operation);
        }
        return operationHandler.get(operation);
    }

    private void fillMap() {
        operationHandler.put(FruitTransaction.Operation.BALANCE,
                new BalanceTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.SUPPLY,
                new SupplyTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.RETURN,
                new ReturnTransactionHandleImpl(storage));
        operationHandler.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseTransactionHandleImpl(storage));

    }
}
