package core.basesyntax.operation;

import core.basesyntax.service.ShopService;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    private ShopService shopService;

    public ReturnHandler(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.RETURN) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            shopService.addFruits(fruit, quantity);
        } else {
            throw new RuntimeException("Unsupported operation for ReturnHandler");
        }
    }
}
