package core.basesyntax.serviceimpl;

import core.basesyntax.strategyimpl.OperationStrategyImpl;
import java.util.List;

public class ExecuteOperations {
    private final OperationStrategyImpl strategy = new OperationStrategyImpl();

    public void separateFruitsAndValues(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            strategy.get(transaction.getOperation())
                    .handle(transaction.getFruit(), transaction.getQuantity());
        }
    }
}

