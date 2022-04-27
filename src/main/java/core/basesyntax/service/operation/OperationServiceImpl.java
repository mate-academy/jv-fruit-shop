package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.handlers.OperationHandler;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private final OperationStrategy operationStrategy;

    public OperationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruit : fruitTransactions) {
            OperationHandler operationHandler = operationStrategy.get(fruit.getOperation());
            operationHandler.doOperation(fruit);
        }
    }
}
