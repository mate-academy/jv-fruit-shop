package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.FruitTransaction;

public class SupplyOperationStrategy implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        Storage.getFruitShop().replace(transaction.getFruit(), transaction.getQuantity()
                + Storage.getFruitShop().get(transaction.getFruit()));

    }
}
