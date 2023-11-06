package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.DataProcessor;
import java.util.List;

public class DataProcessorImpl implements DataProcessor {
    private final OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .doOperation(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
