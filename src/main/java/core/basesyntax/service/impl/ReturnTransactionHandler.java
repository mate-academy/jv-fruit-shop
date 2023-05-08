package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService) {
        if (Storage.remnantsOfGoods.containsKey(fruitTransaction.getFruit())) {
            fruitService.addFruit(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        } else {
            fruitService.setFruit(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
