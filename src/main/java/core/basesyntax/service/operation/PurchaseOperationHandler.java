package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public Fruit handle(FruitTransaction fruitTransaction) {
        Fruit fruit = Storage.fruits.get(fruitTransaction.getName());
        if (fruit == null) {
            throw new RuntimeException("Can't purchase! Actual quantity of "
                    + fruitTransaction.getName() + " is zero!");
        }
        if (fruitTransaction.getQuantity() < fruit.getQuantity()) {
            fruit.setQuantity(fruit.getQuantity() - fruitTransaction.getQuantity());
            Storage.fruits.put(fruitTransaction.getName(), fruit);
            return fruit;
        }
        throw new RuntimeException("Purchase can't exceed actual quantity! Purchase quantity: "
                + fruitTransaction.getQuantity() + " Actual quantity " + fruit.getQuantity());
    }
}
