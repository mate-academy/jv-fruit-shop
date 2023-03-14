package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;

public class FruitReturnOperation implements FruitOperation {
    @Override
    public void fruitOperate(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),
                Storage.fruitsStorage
                        .get(fruitTransaction.getFruit()) + fruitTransaction.getQuantity());
    }
}
