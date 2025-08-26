package core.basesyntax.fruittransactionhandler;

import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = core.basesyntax.datatoreport.dbStorage
                .getDataStorageMap().get(fruitTransaction.getFruit());
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .put(fruitTransaction.getFruit(), 0);
        if (oldValue - fruitTransaction.getQuantity() >= 0) {
            core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                    .put(fruitTransaction.getFruit(), oldValue - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("The result of purchase operation is negative.");
        }
    }
}
