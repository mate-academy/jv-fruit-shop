package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.strategy.OperationStrategy;

public class ReturnOperation implements OperationStrategy {
    private StorageRepository repository;

    public ReturnOperation(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Transaction transaction) {
        Integer actualAmount = repository.getProducts().get(transaction.getProduct());
        Integer newAmount = actualAmount + transaction.getValue();
        transaction.setValue(newAmount);
        repository.add(transaction);
    }
}
