package core.basesyntax.service;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void processData(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.execute(fruitTransaction.getFruit().getName(),
                    fruitTransaction.getFruit().getQuantity());
        }
    }
}
