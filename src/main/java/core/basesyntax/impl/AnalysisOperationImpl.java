package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisOperation;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class AnalysisOperationImpl implements AnalysisOperation {
    private final OperationStrategy operationStrategy;

    public AnalysisOperationImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processing(List<FruitTransaction> data) {
        data.forEach(this::processTransaction);
    }

    private void processTransaction(FruitTransaction transaction) {
        OperationService strategy = operationStrategy.get(transaction);
        strategy.operation(transaction);
    }
}
