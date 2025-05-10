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

        if (Storage.getFruitStorage().containsKey(fruitTransaction.getFruit())) {
            Storage.updateFruitStorage(
                    fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            Storage.updateFruitStorage(
                    fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
