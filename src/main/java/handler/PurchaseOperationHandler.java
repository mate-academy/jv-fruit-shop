package handler;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        isValidFruit(fruitTransaction.getFruit());
        int quantityInDataBase = Storage.getFruitsMap().get(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() <= quantityInDataBase) {
            Storage.getFruitsMap().put(fruitTransaction.getFruit(),
                    quantityInDataBase - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough " + fruitTransaction.getFruit());
        }

    }

    private void isValidFruit(String fruit) {
        if (!Storage.getFruitsMap().containsKey(fruit)) {
            throw new RuntimeException("There is no " + fruit + " in the database");
        }
    }
}
