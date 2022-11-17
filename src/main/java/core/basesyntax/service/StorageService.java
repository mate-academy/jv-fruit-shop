package core.basesyntax.service;

import core.basesyntax.strategy.FruitStrategy;

public class StorageService implements IStorageService {
    private final FruitStrategy fruitStrategy;

    public StorageService(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public void operation(String operation, String fruit, Integer quantity) {
        if (checkData(operation, fruit, quantity)) {
            fruitStrategy.chooseOperation(operation, fruit, quantity);
        } else {
            throw new RuntimeException("Wrong data");
        }
    }

    private boolean checkData(String operation, String fruit, Integer quantity) {
        return operation != null && fruit != null && quantity != null
                && operation.length() == 1 && !fruit.isEmpty() && quantity < Integer.MAX_VALUE >> 2;
    }
}
