package core.basesyntax.service.operations;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler{
    @Override
    public void proceedOperation(FruitTransaction fruitTransaction) {
        if (Storage.fruits.get(fruitTransaction.getFruit()) != null) {
            Integer fruitsQuantity = Storage.fruits.get(fruitTransaction.getFruit());
            int fruitsQuantityPlusSupply = fruitsQuantity + fruitTransaction.getQuantity();
            Storage.fruits.put(fruitTransaction.getFruit(), fruitsQuantityPlusSupply);
        }
        else {
            Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
