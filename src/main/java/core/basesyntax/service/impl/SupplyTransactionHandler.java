package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        FruitService fruitService = new FruitServiceImpl();
        if (null != Storage.remnantsOfGoods.keySet().stream()
                .filter(o -> o.equals(fruitTransaction.getFruit()))
                .findFirst()
                .orElse(null)) {
            fruitService.updateFruit(Storage.remnantsOfGoods, fruitService
                    .getFruit(fruitTransaction.getFruit()), fruitTransaction.getQuantity());
        } else {
            fruitService.addFruit(Storage.remnantsOfGoods, fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
    }
}
