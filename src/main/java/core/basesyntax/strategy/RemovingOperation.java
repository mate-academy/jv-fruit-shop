package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class RemovingOperation implements OperationHandler {
    private final FruitStorageDao fruitStorage;

    public RemovingOperation(FruitStorageDao fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void action(Fruit fruit, int quantity) {
        isPositiveQuantity(quantity);
        int resultQuantity = fruitStorage.getQuantity(fruit) - quantity;
        if (resultQuantity < 0) {
            throw new RuntimeException("Can't remove " + fruit + "result quantity is negative");
        }
        fruitStorage.update(fruit, resultQuantity);
    }
}

