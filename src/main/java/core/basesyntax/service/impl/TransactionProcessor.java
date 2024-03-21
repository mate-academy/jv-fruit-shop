package core.basesyntax.service.impl;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.Processor;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class TransactionProcessor implements Processor {
    private final List<FruitTransaction> fruitTransactions;
    private final OperationStrategy operationStrategy;

    public TransactionProcessor(List<FruitTransaction> fruitTransactions,
                                Map<String, OperationHandler> services) {
        this.fruitTransactions = fruitTransactions;
        operationStrategy = new OperationStrategy(services);
    }

    @Override
    public void process() {
        for (var element : fruitTransactions) {
            operationStrategy.getOperation(element.getOperation()).handle(element);
        }
    }
}
