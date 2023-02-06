package core.basesyntax.strategy.handlers;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (Storage.fruitsQuantity.get(fruitTransaction.getFruit()) != null) {
            Integer fruitsQuantity = Storage.fruitsQuantity.get(fruitTransaction.getFruit());
            int fruitsQuantityPlusSupply = fruitsQuantity + fruitTransaction.getQuantity();
            Storage.fruitsQuantity.put(fruitTransaction.getFruit(), fruitsQuantityPlusSupply);
        } else {
            Storage.fruitsQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
