package service.operation;

import static model.FruitTransaction.MIN_QUANTITY;

import data.db.Storage;
import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() <= MIN_QUANTITY) {
            return;
        }
        if (Storage.getFruitsStorage().containsKey(fruitTransaction.getFruit())) {
            Storage.updateFruitsStorage(fruitTransaction.getFruit(),
                    Storage.getFruitsStorage().get(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        } else {
            Storage.updateFruitsStorage(
                    fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
