package core.basesyntax.handlers;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        int quantityInStorage = DataBase.mapDb.get(fruit);
        DataBase.mapDb.put(fruit, quantityInStorage + quantity);
    }
}
