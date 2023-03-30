package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int quantity = FruitStorage.fruitStorage.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        FruitStorage.put(fruitTransaction.getFruit(), quantity);

    }
}
