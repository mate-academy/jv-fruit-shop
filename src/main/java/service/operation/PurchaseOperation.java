package service.operation;

import static model.FruitTransaction.MIN_QUANTITY;

import data.db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null || fruitTransaction.getFruit() == null
                || fruitTransaction.getQuantity() < MIN_QUANTITY) {
            throw new RuntimeException("Invalid fruitTransaction input");
        }

        if (Storage.getFruitsStorage().containsKey(fruitTransaction.getFruit())) {
            Storage.updateFruitsStorage(fruitTransaction.getFruit(),
                    Math.max(Storage.getFruitsStorage().get(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity(), MIN_QUANTITY));
        }
    }
}
