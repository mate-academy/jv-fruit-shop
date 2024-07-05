package core.basesyntax.strategy.operation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import java.util.Optional;

public class SupplyOperation implements FruitOperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void applyOperation(String fruit, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Illegal amount value" + amount);
        }
        Optional<Fruit> receivedFruit = Optional.of(storageDao.getFruit(fruit));
        int newQuantity = receivedFruit
                .orElseThrow(() -> new RuntimeException("Can't update a fruit"))
                .getQuantity() + amount;
        storageDao.update(fruit, newQuantity);
    }
}
