package core.basesyntax.operation;

import core.basesyntax.service.ShopService;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private ShopService shopService;

    public BalanceHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.BALANCE) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            shopService.addFruits(fruit, quantity);
        } else {
            throw new RuntimeException("Unsupported operation for BalanceHandler");
        }
    }
}
