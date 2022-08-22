package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public Fruit handle(FruitTransaction fruitTransaction) {
        if (!Storage.fruits.containsKey(fruitTransaction.getName())) {
            Storage.fruits.put(fruitTransaction.getName(), fruitTransaction);
            return fruitTransaction;
        }
        Fruit fruit = Storage.fruits.get(fruitTransaction.getName());
        fruit.setQuantity(fruitTransaction.getQuantity() + fruit.getQuantity());
        Storage.fruits.put(fruitTransaction.getName(), fruit);
        return fruit;
    }
}
