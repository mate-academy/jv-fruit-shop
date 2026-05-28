package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationStrategies;

    public FruitServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationStrategies) {
        this.operationStrategies = operationStrategies;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategies.get(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }
            handler.handle(transaction);
        }
        return Storage.fruits;
    }
}
