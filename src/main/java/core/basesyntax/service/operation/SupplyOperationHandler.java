package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public Fruit handle(FruitTransaction fruitTransaction) {
        if (!Storage.fruits.containsKey(fruitTransaction.getType())) {
            Storage.fruits.put(fruitTransaction.getType(), fruitTransaction);
            return fruitTransaction;
        }
        Fruit fruit = Storage.fruits.get(fruitTransaction.getType());
        fruit.setQuantity(fruitTransaction.getQuantity() + fruit.getQuantity());
        Storage.fruits.put(fruitTransaction.getType(), fruit);
        return fruit;
    }
}
