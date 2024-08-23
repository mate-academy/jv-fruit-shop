package service.operation;

import static model.FruitTransaction.MIN_QUANTITY;

import data.db.Storage;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null || fruitTransaction.getFruit() == null
                || fruitTransaction.getQuantity() < MIN_QUANTITY) {
            throw new RuntimeException("Invalid fruitTransaction input");
        }

        if (Storage.getFruitsStorage().containsKey(fruitTransaction.getFruit())) {
            Storage.updateFruitsStorage(
                    fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            Storage.updateFruitsStorage(
                    fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
