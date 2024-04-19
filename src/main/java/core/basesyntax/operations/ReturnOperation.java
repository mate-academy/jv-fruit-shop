package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Can't complete the return");
        }
        int currentBalance = Storage.getFruitBalance().get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.setFruitBalance(fruitTransaction.getFruit(), currentBalance);
    }
}
