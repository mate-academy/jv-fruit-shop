package core.basesyntax.service.impl;

import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class CalculateServiceImpl implements CalculateService {
    private final TransactionStrategy strategy = new TransactionStrategy();

    @Override
    public void calculate(List<StorageTransaction> transactions) {
        for (StorageTransaction transaction : transactions) {
            strategy.getTransaction(transaction).doTransaction(transaction);
        }
    }
}
