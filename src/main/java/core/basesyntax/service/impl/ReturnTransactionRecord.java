package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;

public class ReturnTransactionRecord implements TransactionRecord {
    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        FruitService fruitService = new FruitServiceImpl();
        if (null != Storage.fruits.stream()
                .filter(o -> o.getFruit().equals(fruitTransaction.getFruit()))
                .findFirst()
                .orElse(null)) {
            fruitService.updateFruit(fruitService.getFruit(fruitTransaction.getFruit()),
                    fruitTransaction.getQuantity());
        } else {
            fruitService.addFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
