package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class CalculationServiceImpl implements CalculationService {
    private OperationStrategy operationStrategy;

    public CalculationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculateTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).updateBalance(transaction);
        }
    }
}
