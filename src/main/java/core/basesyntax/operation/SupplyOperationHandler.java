package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Unable to complete the return");
        }
        int currentBalance = Storage.getFruitBalance().get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.setFruitBalance(fruitTransaction.getFruit(), currentBalance);
    }
}
