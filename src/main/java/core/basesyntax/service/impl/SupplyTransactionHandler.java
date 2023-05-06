package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        FruitService fruitService = new FruitServiceImpl();
        if (Storage.remnantsOfGoods.containsKey(fruitTransaction.getFruit())) {
            fruitService.updateFruit(fruitTransaction, fruitTransaction.getQuantity());
        } else {
            fruitService.addFruit(Storage.remnantsOfGoods, fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
