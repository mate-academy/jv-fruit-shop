package core.basesyntax.strategy;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;

public class RemoveOperation implements OperationHandler {
    private final FruitStorageDao fruitStorage;

    public RemoveOperation(FruitStorageDao dao) {
        this.fruitStorage = dao;
    }

    @Override
    public void apply(Fruit fruit, int quantity) {
        int resultQuantity = fruitStorage.getQuantity(fruit) - quantity;
        if (resultQuantity < 0) {
            throw new RuntimeException("Can't remove " + fruit + "result quantity is negative");
        }
        fruitStorage.update(fruit, resultQuantity);
    }
}

