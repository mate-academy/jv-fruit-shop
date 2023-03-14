package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitOperation;

public class FruitBalanceOperation implements FruitOperation {
    @Override
    public void fruitOperate(FruitTransaction fruitTransaction) {
        Storage.fruitsStorage.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
