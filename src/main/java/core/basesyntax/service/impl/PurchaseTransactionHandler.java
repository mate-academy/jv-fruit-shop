package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class PurchaseTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService) {
        int remainder = (Storage.remnantsOfGoods.getOrDefault(fruitTransaction.getFruit(), 0));
        if (remainder - fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("Check the "
                    + "data is a negative quantity of the product: " + fruitTransaction.getFruit());
        }
        if (Storage.remnantsOfGoods.containsKey(fruitTransaction.getFruit())) {
            fruitService.addFruit(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity() * -1);
        } else {
            fruitService.setFruit(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity() * -1);
        }
    }
}
