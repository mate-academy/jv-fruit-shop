package core.basesyntax.fruittransactionhandler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = Storage.getDataStorageMap()
                .get(fruitTransaction.getFruit());
        Storage.getDataStorageMap().put(fruitTransaction.getFruit(), 0);
        Storage.getDataStorageMap()
                .compute(fruitTransaction.getFruit(), (k, currentValue)
                        -> oldValue + fruitTransaction.getQuantity());
    }
}
