package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CalculationService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class CalculationServiceImpl implements CalculationService {
    private TransactionStrategy transactionStrategy;

    public CalculationServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            transactionStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
