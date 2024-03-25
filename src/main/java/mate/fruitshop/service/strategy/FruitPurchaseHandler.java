package mate.fruitshop.service.strategy;

import mate.fruitshop.model.FruitTransaction;

public class FruitPurchaseHandler implements FruitTransactionHandler {
    @Override
    public int conductTransaction(FruitTransaction transaction, int currentQuantity) {
        checkPositiveQuantity(transaction);
        int result = currentQuantity - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Cannot conduct purchase transaction - not enough "
                    + transaction.getFruit() + " available");
        }
        return result;
    }
}
