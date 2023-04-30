package service.impl;

import static db.StorageTotalBalance.fruitStorageTotalBalance;

import model.FruitTransaction;
import service.OperationHandler;

public class AddingOperationHandler implements OperationHandler {
    public void handle(FruitTransaction fruit) {
        int quantity = (fruitStorageTotalBalance.containsKey(fruit.getFruit()))
                ? fruitStorageTotalBalance.get(fruit.getFruit()) + fruit.getQuantity() :
                fruit.getQuantity();
        fruitStorageTotalBalance.put(fruit.getFruit(), quantity);
    }
}
