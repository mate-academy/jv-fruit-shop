package service.impl;

import static db.StorageTotalBalance.fruitStorageTotalBalance;

import model.FruitTransaction;
import service.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    public void handle(FruitTransaction fruit) {
        int quantity = (fruitStorageTotalBalance.containsKey(fruit.getFruit()))
                ? fruitStorageTotalBalance.get(fruit.getFruit()) - fruit.getQuantity() :
                fruit.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("There are not enough "
                    + fruit.getFruit()
                    + " in the fruit storage!");
        }
        fruitStorageTotalBalance.put(fruit.getFruit(), quantity);
    }
}
