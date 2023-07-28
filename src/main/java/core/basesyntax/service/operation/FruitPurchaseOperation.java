package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;

public class FruitPurchaseOperation implements FruitOperation {
    @Override
    public void fruitOperate(FruitTransaction fruitTransaction) {
        if (Storage.fruitStorage.get(fruitTransaction.getFruit())
                >= fruitTransaction.getQuantity()) {
            Storage.fruitStorage.put(fruitTransaction.getFruit(),
                    Storage.fruitStorage
                            .get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity());
        }
        throw new RuntimeException("Customer trying to buy fruits > balance");
    }

}
