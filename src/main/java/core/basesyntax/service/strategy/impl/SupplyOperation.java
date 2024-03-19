package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Optional;

public class SupplyOperation implements OperationStrategy {
    private StorageRepository repository;

    public SupplyOperation(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Transaction transaction) {
        Optional<Integer> actualAmount = Optional
                .ofNullable(repository.getProducts().get(transaction.getProduct()));
        Integer newAmount = actualAmount.orElse(0) + transaction.getValue();
        transaction.setValue(newAmount);
        repository.addProduct(transaction);
    }
}
