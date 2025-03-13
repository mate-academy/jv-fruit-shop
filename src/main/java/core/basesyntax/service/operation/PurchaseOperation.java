package core.basesyntax.service.operation;

import core.basesyntax.service.db.Storage;
import core.basesyntax.service.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        if (Storage.fruits.containsKey(transaction.getFruit())) {
            Storage.fruits.put(transaction.getFruit(),
                    Storage.fruits.get(transaction.getFruit()) - transaction.getQuantity());
        } else {
            System.out.println("Error: Fruit " + transaction.getFruit()
                    + " is not found in storage.");
        }
    }
}
