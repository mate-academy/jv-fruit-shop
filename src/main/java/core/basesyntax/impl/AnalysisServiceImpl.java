package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class AnalysisServiceImpl implements AnalysisService {
    private final OperationStrategy operationStrategy;

    public AnalysisServiceImpl(OperationStrategy operationStrategy) {
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
