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
        fruitStorage.update(fruit, resultQuantity);
    }
}

