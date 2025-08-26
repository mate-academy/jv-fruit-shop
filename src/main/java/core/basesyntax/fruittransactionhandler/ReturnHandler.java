package core.basesyntax.fruittransactionhandler;

import core.basesyntax.datatoreport.dbStorage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldValue = dbStorage.getDataStorageMap()
                .get(fruitTransaction.getFruit());
        dbStorage.getDataStorageMap().put(fruitTransaction.getFruit(), 0);
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .compute(fruitTransaction.getFruit(),
                (k, currentValue) -> oldValue + fruitTransaction.getQuantity());
    }
}
