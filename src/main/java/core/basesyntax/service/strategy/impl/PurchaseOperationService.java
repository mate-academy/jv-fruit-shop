package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationService;
import core.basesyntax.storage.TemporaryStorage;

public class PurchaseOperationService implements OperationService {
    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        checkPurchasingPossibility(fruitTransaction);
        if (isOnBalanceSheet(fruitTransaction)) {
            int oldValue = TemporaryStorage.temporaryStorage.get(fruitTransaction.getFruit());
            int newValue = oldValue - fruitTransaction.getQuantity();
            TemporaryStorage.temporaryStorage.put(fruitTransaction.getFruit(), newValue);
        } else {
            throw new RuntimeException(fruitTransaction.getFruit() + " fruit"
                    + " isn't on the balance sheet. You can't "
                    + "purchase it");
        }
    }

    private void checkPurchasingPossibility(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity()
                > TemporaryStorage.temporaryStorage.get(fruitTransaction.getFruit())) {
            throw new RuntimeException("You can't purchase \"" + fruitTransaction.getQuantity()
                    + " units of " + fruitTransaction.getFruit()
                    + "\". There is not enough such fruits on balance");
        }
    }
}
