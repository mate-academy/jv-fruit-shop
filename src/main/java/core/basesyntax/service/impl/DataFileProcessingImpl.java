package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataFileProcessing;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataFileProcessingImpl implements DataFileProcessing {
    private final OperationStrategy operationStrategy;

    public DataFileProcessingImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> transactions) {
        for (var transaction : transactions) {
            operationStrategy.handleOperation(transaction);
        }
    }
}
