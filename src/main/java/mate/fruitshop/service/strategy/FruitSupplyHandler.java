package mate.fruitshop.service.strategy;

import mate.fruitshop.model.FruitTransaction;

public class FruitSupplyHandler implements FruitTransactionHandler {
    @Override
    public int conductTransaction(FruitTransaction transaction, int currentQuantity) {
        checkPositiveQuantity(transaction);
        return currentQuantity + transaction.getQuantity();
    }
}
