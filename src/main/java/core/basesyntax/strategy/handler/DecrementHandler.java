package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class DecrementHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        Fruit existingFruit = Storage.getFruit(fruit.getName());
        if (existingFruit == null || existingFruit.getQuantity() < quantity) {
            throw new RuntimeException("Not enough fruit available.");
        }
        existingFruit.subtractQuantity(quantity);
        Storage.addOrUpdateFruit(existingFruit.getName(), existingFruit);
    }
}

