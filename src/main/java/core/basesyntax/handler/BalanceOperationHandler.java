package core.basesyntax.handler;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void get(FruitTransaction fruitTransaction) {

        Storage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
