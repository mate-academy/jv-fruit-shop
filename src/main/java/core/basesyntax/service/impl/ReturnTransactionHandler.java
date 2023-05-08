package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService) {
        fruitService.addFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());

    }
}
