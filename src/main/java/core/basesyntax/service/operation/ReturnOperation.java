package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.exceptions.NoSuchFruitException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;

public class ReturnOperation implements Operation {
    @Override
    public void doOperation(Fruit fruit) {
        if (!FruitStorage.contains(fruit)) {
            throw new NoSuchFruitException(OperationType.RETURN, fruit);
        }
        FruitStorage.fruits.stream()
                .filter(x -> x.getName().equals(fruit.getName()))
                .findFirst().get()
                .add(fruit.getQuantity());
    }
}
