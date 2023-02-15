package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class ReturnStrategy extends FruitShopStrategy {
    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
