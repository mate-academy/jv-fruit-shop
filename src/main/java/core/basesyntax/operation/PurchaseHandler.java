package core.basesyntax.operation;

import core.basesyntax.transaction.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private ShopServiceImpl shopServiceImpl;

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        int currentQuantity = shopServiceImpl.getQuantity(fruit);
        if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
            if (transactionQuantity > currentQuantity) {
                throw new RuntimeException("Not enough " + fruit + " in stock for purchase");
            }
            shopServiceImpl.addFruits(fruit, currentQuantity - transactionQuantity);
        } else {
            throw new RuntimeException("Unsupported operation for PurchaseHandler");
        }
    }
}
