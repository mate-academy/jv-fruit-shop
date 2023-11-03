package core.basesyntax;

import core.basesyntax.db.Storage;

import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (!Storage.shopStorage.containsKey(fruitTransaction.getFruit())) {
            Storage.shopStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
