package core.basesyntax.operation;

import core.basesyntax.service.ShopService;
import core.basesyntax.transaction.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private ShopService shopService;

    public PurchaseHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int transactionQuantity = transaction.getQuantity();
        int currentQuantity = shopService.getQuantity(fruit);
        if (transaction.getOperation() == FruitTransaction.Operation.PURCHASE) {
            if (transactionQuantity > currentQuantity) {
                throw new RuntimeException("Not enough " + fruit + " in stock for purchase");
            }
            shopService.addFruits(fruit, currentQuantity - transactionQuantity);
        } else {
            throw new RuntimeException("Unsupported operation for PurchaseHandler");
        }
    }
}
