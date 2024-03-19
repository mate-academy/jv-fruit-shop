package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.strategy.OperationStrategy;

public class BalanceOperation implements OperationStrategy {
    private StorageRepository repository;

    public BalanceOperation(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Transaction transaction) {
        repository.addProduct(transaction);
    }
}
