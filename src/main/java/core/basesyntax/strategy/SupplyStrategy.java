package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class SupplyStrategy extends FruitShopStrategy {

    @Override
    public void apply(FruitTransaction transaction) {
        storageDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
