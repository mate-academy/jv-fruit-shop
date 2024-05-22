package core.basesyntax.operations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        validateInPut(fruitTransaction);
        int currentBalance = Storage.getFruitBalance().get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.setFruitBalance(fruitTransaction.getFruit(), currentBalance);
    }
}
