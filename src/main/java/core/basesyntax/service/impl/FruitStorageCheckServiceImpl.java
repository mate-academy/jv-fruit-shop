package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitStorageCheckService;
import core.basesyntax.strategy.CountStrategy;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorageCheckServiceImpl implements FruitStorageCheckService {
    private OperationStrategy operationStrategy;

    public FruitStorageCheckServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> checkStorage(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> resultFruitMap = new HashMap<>();
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            CountStrategy countStrategy = operationStrategy.getCountStrategyMap(operation);
            String fruitName = transaction.getFruit();
            int operationQuantity = transaction.getQuantity();
            int currentQuantity;
            if (operation == FruitTransaction.Operation.BALANCE) {
                currentQuantity = 0;
            } else {
                currentQuantity = resultFruitMap.get(fruitName);
            }
            int newAmount = countStrategy.count(currentQuantity, operationQuantity);
            resultFruitMap.put(fruitName, newAmount);
        }
        return resultFruitMap;
    }
}
