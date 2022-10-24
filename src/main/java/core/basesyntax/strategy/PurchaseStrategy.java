package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class PurchaseStrategy extends FruitShopStrategy {

    @Override
    public void apply(FruitTransaction transaction) {
        try {
            storageDao.subtract(transaction.getFruit(), transaction.getQuantity());
        } catch (RuntimeException e) {
            throw new RuntimeException("Error purchasing "
                    + transaction.getQuantity() + " "
                    + transaction.getFruit() + "(s)", e);
        }
    }
}
