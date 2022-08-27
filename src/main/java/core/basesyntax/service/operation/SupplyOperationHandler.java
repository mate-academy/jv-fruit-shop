package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Fruit fruit = new Fruit(fruitTransaction.getName(), fruitTransaction.getQuantity());
        Storage.fruits.merge(fruit.getName(), fruit, (fr1, fr2) -> fr1 == null ? fruit
                : new Fruit(fruit.getName(), Storage.fruits.get(fruit.getName()).getQuantity()
                + fruit.getQuantity()));
    }
}
