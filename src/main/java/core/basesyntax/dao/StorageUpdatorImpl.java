package core.basesyntax.dao;

import core.basesyntax.dao.operation.Operation;
import core.basesyntax.dao.operation.OperationHandler;
import core.basesyntax.dao.transaction.FruitTransaction;

import java.util.List;

public class StorageUpdatorImpl implements StorageUpdator {
    @Override
    public void updateStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = fruitTransaction;
        }
    }
}
