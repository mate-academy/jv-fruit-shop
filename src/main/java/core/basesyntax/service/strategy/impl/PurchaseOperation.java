package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.strategy.OperationStrategy;

public class PurchaseOperation implements OperationStrategy {
    private static final String AVAILABLE_AMOUNT = "Transaction value exceeds available amount";
    private StorageRepository repository;

    public PurchaseOperation(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Transaction transaction) {
        Integer currentAmount = repository.getProducts().getOrDefault(transaction.getProduct(), 0);
        int newValue = currentAmount - transaction.getValue();
        validateValue(newValue);
        transaction.setValue(newValue);
        repository.add(transaction);
    }

    private void validateValue(int newValue) {
        if (newValue < 0) {
            throw new IllegalArgumentException(AVAILABLE_AMOUNT);
        }
    }
}
