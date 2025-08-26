package core.basesyntax.fruittransactionhandler;

import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = core.basesyntax.datatoreport.dbStorage
                .getDataStorageMap().get(fruitTransaction.getFruit());
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .put(fruitTransaction.getFruit(), 0);
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .compute(fruitTransaction.getFruit(),
                (k, currentValue) -> oldValue + fruitTransaction.getQuantity());
    }
}
