package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class IncrementHandler implements OperationHandler {
    @Override
    public void apply(Fruit fruit, int quantity) {
        Fruit existingFruit = Storage.getFruit(fruit.getName());
        if (existingFruit == null) {
            existingFruit = new Fruit(fruit.getName());
        }
        existingFruit.addQuantity(quantity);
        Storage.addOrUpdateFruit(fruit.getName(), existingFruit);
    }
}
