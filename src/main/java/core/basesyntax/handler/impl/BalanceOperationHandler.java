package core.basesyntax.handler.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements ShopOperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());

    }
}
