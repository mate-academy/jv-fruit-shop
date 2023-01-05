package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.CountStrategy;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final OperationStrategy operationStrategy;
    private final Storage storage = new Storage();

    public StorageServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> update(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitMap = storage.getFruitMap();
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            CountStrategy countStrategy = operationStrategy.getCountStrategyMap(operation);
            String fruitName = transaction.getFruit();
            int operationQuantity = transaction.getQuantity();
            int currentQuantity;
            if (operation == FruitTransaction.Operation.BALANCE) {
                currentQuantity = 0;
            } else {
                currentQuantity = fruitMap.get(fruitName);
            }
            int newAmount = countStrategy.count(currentQuantity, operationQuantity);
            fruitMap.put(fruitName, newAmount);
        }
        return fruitMap;
    }
}
