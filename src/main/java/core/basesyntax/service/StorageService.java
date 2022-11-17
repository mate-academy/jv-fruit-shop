package core.basesyntax.service;

import core.basesyntax.strategy.FruitStrategy;

public class StorageService implements IStorageService {
    private final FruitStrategy fruitStrategy;

    public StorageService(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void operation(String operation, String fruit, Integer quantity) {
        fruitStrategy.chooseOperation(operation, fruit, quantity);
    }
}
