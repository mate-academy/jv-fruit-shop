package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ShopService;

public class BalanceOperation implements OperationHandler {
    private ShopService shopService;

    public BalanceOperation(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.BALANCE) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            shopService.addFruits(fruit, quantity);
        } else {
            throw new RuntimeException("Unsupported operation for BalanceHandler");
        }
    }
}
