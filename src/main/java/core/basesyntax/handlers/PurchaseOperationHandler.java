package core.basesyntax.handlers;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        int quantityInStorage = DataBase.mapDb.get(fruit);
        if (quantityInStorage < quantity) {
            throw new RuntimeException("Not enough fruits in storage. Come back later "
            + "Quantity in storage :" + quantityInStorage + ", but your order has :"
            + quantity);
        }
        DataBase.mapDb.put(fruit, quantityInStorage - quantity);
    }
}
