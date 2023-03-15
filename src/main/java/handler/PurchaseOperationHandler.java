package handler;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        isValidFruit(fruitTransaction.getFruit());
        int quantityInDataBase = Storage.fruits.get(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() <= quantityInDataBase) {
            Storage.fruits.put(fruitTransaction.getFruit(),
                    quantityInDataBase - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough " + fruitTransaction.getFruit());
        }

    }

    private void isValidFruit(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("There is no " + fruit + " in the database");
        }
    }
}
