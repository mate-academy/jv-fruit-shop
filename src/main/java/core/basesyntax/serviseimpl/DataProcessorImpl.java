package core.basesyntax.serviseimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.servise.DataProcessor;
import core.basesyntax.servise.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {
    private final Map<Operation, OperationStrategy> operationStrategies;

    public DataProcessorImpl(Map<Operation, OperationStrategy> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitStore = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            OperationStrategy strategy = operationStrategies.get(transaction.getOperation());
            if (strategy == null) {
                throw new RuntimeException("No strategy for operation "
                        + transaction.getOperation());
            }
            int balance = fruitStore.getOrDefault(transaction.getFruit(), 0);
            fruitStore.put(transaction.getFruit(),
                    strategy.apply(balance, transaction.getQuantity()));
        }
        return fruitStore;
    }
}
