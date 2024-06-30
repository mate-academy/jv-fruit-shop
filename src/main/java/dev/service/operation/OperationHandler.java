package dev.service.operation;

import dev.repository.FruitStore;

public interface OperationHandler {
    void update(FruitStore repository, String keyFruit, Integer value);
}
