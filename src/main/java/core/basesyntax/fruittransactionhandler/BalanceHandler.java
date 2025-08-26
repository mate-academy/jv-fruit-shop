package core.basesyntax.fruittransactionhandler;

import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .put(fruitTransaction.getFruit(), 0);
        core.basesyntax.datatoreport.dbStorage.getDataStorageMap()
                .put(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
    }
}
