package core.basesyntax.service.operations;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler{
    @Override
    public void proceedOperation(FruitTransaction fruitTransaction) {
        if (Storage.report.get(fruitTransaction.getFruit()) != null) {
            Integer fruitsQuantity = Storage.report.get(fruitTransaction.getFruit());
            int fruitsQuantityPlusSupply = fruitsQuantity + fruitTransaction.getQuantity();
            Storage.report.put(fruitTransaction.getFruit(), fruitsQuantityPlusSupply);
        }
        else {
            Storage.report.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
