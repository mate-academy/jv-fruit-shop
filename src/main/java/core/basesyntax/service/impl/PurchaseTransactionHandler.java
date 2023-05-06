package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        FruitService fruitService = new FruitServiceImpl();
        if (Storage.remnantsOfGoods.containsKey(fruitTransaction.getFruit())) {
            fruitService.updateFruit(fruitTransaction, fruitTransaction.getQuantity() * -1);
        } else {
            fruitService.addFruit(Storage.remnantsOfGoods, fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity() * -1);
        }
    }
}
