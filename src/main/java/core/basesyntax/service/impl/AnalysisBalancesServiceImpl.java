package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisBalancesService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class AnalysisBalancesServiceImpl implements AnalysisBalancesService {
    private OperationStrategy operationStrategy;

    public AnalysisBalancesServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processing(List<FruitTransaction> transactions) {
        transactions.forEach(transaction ->
                operationStrategy.getOperationType(transaction.getOperation())
                        .revisionOperation(transaction));
    }
}
