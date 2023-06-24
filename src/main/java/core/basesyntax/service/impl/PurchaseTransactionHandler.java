package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService) {
        int balance = Storage.remnantsOfGoods.getOrDefault(fruitTransaction.getFruit(), 0);
        int remainder = balance - fruitTransaction.getQuantity();
        if (remainder < 0) {
            throw new RuntimeException("Check the "
                    + "data is a negative quantity of the product: " + fruitTransaction.getFruit());
        }
        fruitService.setFruit(fruitTransaction.getFruit(), remainder);
    }
}
