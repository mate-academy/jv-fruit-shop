package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessingService;
import java.util.List;
import java.util.Map;
import strategy.OperationCalculate;
import strategy.OperationCalculateStrategy;

public class TransactionProcessingServiceImpl implements TransactionProcessingService {
    private final OperationCalculateStrategy operationCalculateStrategy;
    private final Storage storage;

    public TransactionProcessingServiceImpl(OperationCalculateStrategy operationCalculateStrategy) {
        this.operationCalculateStrategy = operationCalculateStrategy;
        storage = new Storage();
    }

    @Override
    public Map<String, Integer> update(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitMap = storage.getFruitMap();
        for (FruitTransaction transaction : fruitTransactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationCalculate calculate = operationCalculateStrategy.getCountStrategy(operation);
            String fruitName = transaction.getFruit();
            int operationQuantity = transaction.getQuantity();
            int currentQuantity =
                    operation == FruitTransaction.Operation.BALANCE ? 0 : fruitMap.get(fruitName);
            int newAmount = calculate.calculate(currentQuantity, operationQuantity);
            fruitMap.put(fruitName, newAmount);
        }
        return fruitMap;
    }
}
