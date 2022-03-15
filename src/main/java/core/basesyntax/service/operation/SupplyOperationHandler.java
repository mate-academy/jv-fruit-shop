package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.NoSuchFruitException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void doOperation(Fruit fruit) {
        if (!FruitStorage.fruits.contains(fruit)) {
            throw new NoSuchFruitException(OperationType.SUPPLY, fruit);
        }
        FruitStorage.fruits.stream()
                .filter(x -> x.equals(fruit))
                .findFirst().get()
                .add(fruit.getQuantity());
    }
}
