package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;

public class BalanceTransactionHandler implements TransactionHandler {
    @Override
    public void handleTransaction(FruitTransaction fruitTransaction, FruitService fruitService) {
        fruitService.setFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
