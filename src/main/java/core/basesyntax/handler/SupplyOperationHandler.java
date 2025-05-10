package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.modifyFruitStorage(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
