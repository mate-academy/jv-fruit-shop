package dev.service.operation;

import dev.repository.Repository;

public class BalanceOperation implements OperationHandler {
    @Override
    public void update(Repository repository, String keyFruit, Integer value) {
        repository.updateQuantity(keyFruit, value);
    }
}
