package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class AddOperation implements OperationHandler {
    private final FruitStorageDao fruitStorage;

    public AddOperation(FruitStorageDao fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        int resultQuantity = fruitStorage.getQuantity(fruit) + quantity;
        fruitStorage.update(fruit, resultQuantity);
    }
}
