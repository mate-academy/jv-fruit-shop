package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction, Storage fruitStorage) {
        fruitStorage.plusFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
