package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class PurchaseStrategy extends FruitShopStrategy {

    @Override
    public void apply(FruitTransaction transaction) {
        int currentQuantity = storageDao.get(transaction.getFruit())
                .orElseThrow(()
                        -> new RuntimeException("Theres no such fruit: "
                        + transaction.getFruit()));
        if (transaction.getQuantity() > currentQuantity) {
            throw new RuntimeException("You can't remove from storage more than it have (have "
                    + currentQuantity + ")");
        }
        storageDao.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
