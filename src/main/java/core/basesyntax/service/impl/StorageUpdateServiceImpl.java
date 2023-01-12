package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageUpdateService;
import core.basesyntax.service.amount.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class StorageUpdateServiceImpl implements StorageUpdateService {
    private OperationStrategy strategy;

    public StorageUpdateServiceImpl() {
        this.strategy = new OperationStrategyImpl();
    }

    @Override
    public void updateValue(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction e : fruitTransactions) {
            if (Storage.fruitMap.containsKey(e.getFruitType())) {
                OperationHandler operation = strategy.getOperationImpl(e.getOperation());
                operation.updateAmountInStorage(e);
            } else {
                Storage.fruitMap.put(e.getFruitType(), e.getAmount());
            }
        }
    }
}
