package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;

public class FruitPurchaseOperation implements FruitOperation {
    @Override
    public void fruitOperate(FruitTransaction fruitTransaction) {
        if (Storage.FRUIT_STORAGE.get(fruitTransaction.getFruit())
                >= fruitTransaction.getQuantity()) {
            Storage.FRUIT_STORAGE.put(fruitTransaction.getFruit(),
                    Storage.FRUIT_STORAGE
                            .get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
        }
        throw new RuntimeException("Customer trying to buy fruits > balance");
    }

}
