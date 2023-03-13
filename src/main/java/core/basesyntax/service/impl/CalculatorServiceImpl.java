package core.basesyntax.service.impl;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculatorService;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class CalculatorServiceImpl implements CalculatorService {
    private final Strategy strategy;

    public CalculatorServiceImpl(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void calculate(List<StorageTransaction> transactions) {
        for (StorageTransaction transaction : transactions) {
            strategy.getTransaction(transaction).doTransaction(transaction);
        }
    }
}
