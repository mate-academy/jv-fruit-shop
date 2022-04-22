package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.handlers.OperationHandler;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        for (FruitTransaction fruit : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy.get(fruit.getOperation());
            operationHandler.doOperation(fruit);
        }
    }
}
