package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class BalanceStrategy extends FruitShopStrategy {

    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.set(transaction.getFruit(), transaction.getQuantity());
    }
}
