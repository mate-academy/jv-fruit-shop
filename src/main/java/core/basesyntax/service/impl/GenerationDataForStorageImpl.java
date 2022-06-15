package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GenerationDataForStorage;
import java.util.List;

public class GenerationDataForStorageImpl implements GenerationDataForStorage {
    private final OperationStrategyImpl operationStrategy;

    public GenerationDataForStorageImpl(OperationStrategyImpl operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void generateData(List<FruitTransaction> transactionList) {
        transactionList.forEach(t -> operationStrategy
                .get(t.getOperation())
                .makeOperation(t));
    }
}
