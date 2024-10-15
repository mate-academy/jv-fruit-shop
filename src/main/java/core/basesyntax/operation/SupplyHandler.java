package core.basesyntax.operation;

import core.basesyntax.transaction.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private ShopServiceImpl shopServiceImpl;

    @Override
    public void apply(FruitTransaction transaction) {
        if (transaction.getOperation() == FruitTransaction.Operation.SUPPLY) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            shopServiceImpl.addFruits(fruit, quantity);
        } else {
            throw new RuntimeException("Unsupported operation for SupplyHandler");
        }
    }
}
