package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ShopService;

public class PurchaseOperation implements OperationHandler {
    private ShopService shopService;

    public PurchaseOperation(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
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
