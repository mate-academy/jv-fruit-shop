package core.basesyntax.serviseimpl;

import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.DataProcessor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {
    private final Map<Operation, OperationHandler> operationStrategies;

    public DataProcessorImpl(Map<Operation, OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public Map<String, Integer> processTransactions(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitStore = new HashMap<>();
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategies.get(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("No handler for operation "
                        + transaction.getOperation());
            }
            handler.handleTransaction(transaction, fruitStore);
        }
        return fruitStore;
    }
}
