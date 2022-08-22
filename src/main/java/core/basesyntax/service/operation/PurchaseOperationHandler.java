package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public Fruit handle(FruitTransaction fruitTransaction) {
        int purchase = fruitTransaction.getQuantity();
        boolean isPresent = Storage.fruits.containsKey(fruitTransaction.getType());
        Fruit fruit = Storage.fruits.get(fruitTransaction.getType());
        if (isPresent && purchase < fruit.getQuantity()) {
            fruit.setQuantity(fruit.getQuantity() - purchase);
            Storage.fruits.put(fruitTransaction.getType(), fruit);
        } else {
            throw new RuntimeException("Purchase can't exceed actual quantity! Purchase quantity: "
                   + fruitTransaction.getQuantity() + " Actual quantity " + fruit.getQuantity());
        }
        return fruit;
    }
}
